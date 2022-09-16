package com.devpro.karma.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devpro.karma.entities.Users;
import com.devpro.karma.repository.UserRepository;
import com.devpro.karma.services.UserService;

@Controller
public class RegisterController extends BaseController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String defaultRegister() {
		return "/administrator/register";
	}

	@PostMapping("/register/account")
	public ResponseEntity<Map<String, Object>> registerAccount(final HttpServletRequest request, final Model model
			, @RequestBody Users user) {
		PasswordEncoder password = new BCryptPasswordEncoder();
		user.setPassword(password.encode(user.getPassword()));
		userService.createUser(user);
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("200", "Successfully");
		return ResponseEntity.ok(jsonResponse);
	}
//	"redirect:/home";
}
