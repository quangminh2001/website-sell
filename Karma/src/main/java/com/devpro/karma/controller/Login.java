package com.devpro.karma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {
	
	@GetMapping("/login")
	public String loginDefault() {
		
		
		
		
		return "/administrator/login";
	}
	
}
