package someidea.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import someidea.auth.bean.JwtTokenProvider;

@Service
@Slf4j
public class LoginService {
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	
    public String login(String jsonStr) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(jsonStr);
		String userName = jsonNode.get("userName").asText();
		String password = jsonNode.get("password").asText();

    	
        Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(userName, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }
}
