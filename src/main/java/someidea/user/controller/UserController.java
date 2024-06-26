package someidea.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import someidea.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	

	
	@PostMapping("/user/wellcome")
	public String wellcome(@RequestBody String jsonString) {
		return String.format("Wellcome %s");
	}
}
