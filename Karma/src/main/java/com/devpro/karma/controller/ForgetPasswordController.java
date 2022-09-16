package com.devpro.karma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgetPasswordController {
	@GetMapping("/password/forget")
	public String defaultForgetPass() {
		return "administrator/forgot-password";
	}
}
