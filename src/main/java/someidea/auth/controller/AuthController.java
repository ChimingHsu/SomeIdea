package someidea.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import someidea.auth.service.LoginService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	@CrossOrigin
	public String login(@RequestBody String jsonStr) {
		String rtnStr;
		try {
			rtnStr = loginService.login(jsonStr);
			
			Map<String,String> payload = new HashMap<>();
			payload.put("token",rtnStr);
			
			return new ObjectMapper().writeValueAsString(payload);
		}catch(AuthenticationException ae) {
			rtnStr = "login fails: " + ae.getMessage();
		}
		catch(Exception e) {
			rtnStr = "login fails: " + e.getMessage();
		}
		
		return rtnStr;
	}
}
