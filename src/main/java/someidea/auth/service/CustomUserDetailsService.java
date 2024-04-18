package someidea.auth.service;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import someidea.xepdb.entity.AuthUserEntity;
import someidea.xepdb.reposotory.AuthGroupRep;
import someidea.xepdb.reposotory.AuthUserRep;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private AuthUserRep authUserRep;
	
	@Autowired
	private AuthGroupRep groupRep;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	AuthUserEntity user = authUserRep.findByUserName(userName)
    			.orElseThrow(() -> new UsernameNotFoundException("User not exists by UserNo"));
    	
    	Set<GrantedAuthority> authorities = groupRep.findAllByUserName(user.getUserName())
    			.stream()
    			.map((group) -> new SimpleGrantedAuthority(group.getGroupName()))
    			.collect(Collectors.toSet());
    	try {
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
    	}catch(Exception e) {
    		log.info(e.getMessage(),e);
    		throw new UsernameNotFoundException(e.getMessage());
    	}
    }
    
    private boolean isCredentialsNonExpired(AuthUserEntity user) {
    	Date lastChangePswDate = user.getLastLoginDate() == null ? user.getCreateDate() : user.getLastChgPswDate();
    	LocalDateTime now = LocalDateTime.now();
    	long diffDays = Period.between(lastChangePswDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), 
    			now.toLocalDate()).getDays();
    	
    	return user.getPswExpiryDays().longValue() > diffDays;
	}

	private boolean isAccountNonExpired(AuthUserEntity user) {
    	Date lastLoginDate = user.getLastLoginDate() == null ? user.getCreateDate() : user.getLastLoginDate();
    	LocalDateTime now = LocalDateTime.now();
    	long diffDays = Period.between(lastLoginDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), 
    			now.toLocalDate()).getDays();
    	
    	return user.getAccountExpiryDays().longValue() > diffDays;
    	
    }
    
}
