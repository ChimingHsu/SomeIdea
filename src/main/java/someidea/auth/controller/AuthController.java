package someidea.auth.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import someidea.auth.service.LoginService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public String login(@RequestBody String jsonStr) {
		String rtnStr;
		try {
			rtnStr = loginService.login(jsonStr);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("token", rtnStr);
			
			return jsonObj.toString();
		}catch(AuthenticationException ae) {
			rtnStr = "login fails: " + ae.getMessage();
		}
		catch(Exception e) {
			rtnStr = "login fails: " + e.getMessage();
		}
		
		return rtnStr;
	}
}
