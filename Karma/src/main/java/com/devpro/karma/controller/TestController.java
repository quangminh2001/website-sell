package com.devpro.karma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.devpro.karma.services.implement.TestService;

@Controller
public class TestController {
	@Autowired
	TestService testService;
	
	@GetMapping("/test")
	public String testNhe() {
		testService.testConnect();
		return "";
	}
}
