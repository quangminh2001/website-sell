package com.devpro.karma.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class TestClass {
	List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
		System.out.println(passwordEncoder.encode("minh"));
		
	}
}
