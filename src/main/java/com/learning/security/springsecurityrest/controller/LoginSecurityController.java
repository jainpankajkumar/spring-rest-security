package com.learning.security.springsecurityrest.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginSecurityController {
	
	@GetMapping("/home/employee")
	@Secured("ROLE_EMPLOYEE")
	public String sayHiToEmployee() {
		return "Hey, you are authenticated using Employee Role!!!";
	}
	
	@GetMapping("/home/admin")
	@Secured("ROLE_ADMIN")
	public String sayHiToAdmin() {
		return "Hey, you are authenticated using Admin Role!!!";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "Hey, you don't have suffficient role to access this page!!!";
	}

}
