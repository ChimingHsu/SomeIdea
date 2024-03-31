package garyhsu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import garyhsu.springboot.service.TestService;

@RestController
public class TestContorller {
	
	@Autowired
	private TestService service;
	
	@GetMapping("/test")
	public String testController() {
		return service.doTest();
	}
	
	
}
