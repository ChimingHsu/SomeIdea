package someidea.auth.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import someidea.auth.bean.JwtTokenProvider;
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
    	
    	LoggerFactory.getLogger(CustomUserDetailsService.class).info("user Id: "+user.getId());
    	
    	Set<GrantedAuthority> authorities = groupRep.findAllByUserId(user.getId().intValue())
    			.stream()
    			.map((group) -> new SimpleGrantedAuthority(group.getGroupName()))
    			.collect(Collectors.toSet());
    	
    	String auths = authorities.stream().map(g->g.getAuthority()).collect(Collectors.joining(","));
    	
    	LoggerFactory.getLogger(CustomUserDetailsService.class).info("auths: "+auths);
    	
        return new User(
        		user.getUserNo(),
                user.getPassword(),
                authorities
        );
    }
}
