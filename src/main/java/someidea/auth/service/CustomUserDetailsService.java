package someidea.auth.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import someidea.xepdb.entity.AuthUserEntity;
import someidea.xepdb.reposotory.AuthGroupRep;
import someidea.xepdb.reposotory.AuthUserRep;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
    private AuthUserRep authUserRep;
	
	@Autowired
	private AuthGroupRep groupRep;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	AuthUserEntity user = authUserRep.findByUserName(userName)
    			.orElseThrow(() -> new UsernameNotFoundException("User not exists by UserNo"));
    	
    	logger.info("user Id: "+user.getId());
    	
    	Set<GrantedAuthority> authorities = groupRep.findAllByUserName(user.getUserName())
    			.stream()
    			.map((group) -> new SimpleGrantedAuthority(group.getGroupName()))
    			.collect(Collectors.toSet());
    	
    	String auths = authorities.stream().map(g->g.getAuthority()).collect(Collectors.joining(","));
    	logger.info("auths: "+auths);
        boolean enabled = user.getEnabled().equals("Y");
        boolean accountNonExpired = isAccountNonExpired(user);
    	boolean credentialsNonExpired = isCredentialsNonExpired(user);
    	boolean accountNonLocked = user.getLocked().equals("N");
    	return new User(
        		user.getUserName(),
        		user.getPassword(),
        		enabled,
        		accountNonExpired,
        		credentialsNonExpired,
        		accountNonLocked,
                authorities
        );
    }
    
    private boolean isCredentialsNonExpired(AuthUserEntity user) {
    	Date lastChangePswDate = user.getLastLoginDate() == null ? user.getCreateDate() : user.getLastChgPswDate();
    	LocalDateTime now = LocalDateTime.now();
    	long diffDays = Duration.between(lastChangePswDate.toInstant(), now).toDays();
    	
    	return user.getPswExpiryDays().longValue() > diffDays;
	}

	private boolean isAccountNonExpired(AuthUserEntity user) {
    	Date lastLoginDate = user.getLastLoginDate() == null ? user.getCreateDate() : user.getLastLoginDate();
    	LocalDateTime now = LocalDateTime.now();
    	long diffDays = Duration.between(lastLoginDate.toInstant(), now).toDays();
    	
    	return user.getAccountExpiryDays().longValue() > diffDays;
    	
    }
    
}
