package someidea.auth.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import someidea.xepdb.entity.AuthUserEntity;
import someidea.xepdb.reposotory.AuthGroupRep;
import someidea.xepdb.reposotory.AuthUserRep;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private AuthUserRep authUserRep;
	
	@Autowired
	private AuthGroupRep groupRep;
	
    @Override
    public UserDetails loadUserByUsername(String userNo) throws UsernameNotFoundException {
    	AuthUserEntity user = authUserRep.findByUserNo(userNo)
    			.orElseThrow(() -> new UsernameNotFoundException("User not exists by UserNo"));
    	
    	Set<GrantedAuthority> authorities = groupRep.findAllByUserId(user.getId().intValue()).stream()
        .map((role) -> new SimpleGrantedAuthority(role.getGroupName()))
        .collect(Collectors.toSet());
    	

        return new org.springframework.security.core.userdetails.User(
        		userNo,
                user.getPassword(),
                authorities
        );
    }
}
