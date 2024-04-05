package someidel.auth.service;

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

import someidea.db.mes.entity.AdmUserEntity;
import someidea.db.mes.reposotory.AdmUserDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private AdmUserDao admUserDao;

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
