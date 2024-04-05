package someidel.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import someidea.db.xep.reposotory.AuthUserRep;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private AuthUserRep authUserRep;

//	@Autowired
//	private AdmG
	
    @Override
    public UserDetails loadUserByUsername(String userNo) throws UsernameNotFoundException {
//    	AdmUserEntity user = admUserDao.findByUserNo(userNo)
//    			.orElseThrow(() -> new UsernameNotFoundException("User not exists by UserNo"));
//    	
//        Set<GrantedAuthority> authorities = user.getRoles().stream()
//                .map((role) -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toSet());
//
//        return new org.springframework.security.core.userdetails.User(
//        		userNo,
//                user.getPasswrod(),
//                authorities
//        );
    	return null;
    }
}
