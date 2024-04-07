package someidea.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import someidea.user.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/allUsers")
	public String allUsers() {
		try {
			return userService.allUsers();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Query users fails";
	}
	
}
