package someidea.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
		}catch(Exception e) {
			e.printStackTrace();
			rtnStr = "login fails";
		}
		
		return "login success: "+rtnStr;
	}
}
