package com.devpro.karma.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.devpro.karma.entities.Categories;
import com.devpro.karma.entities.Users;
import com.devpro.karma.services.ICategoryService;

public abstract class BaseController {

	@Autowired
	private ICategoryService icategory;

	@ModelAttribute("category")
	public List<Categories> listCate() {
		return icategory.findAllCategoryByStatusTrue();
	}

	public Integer getInteger(HttpServletRequest request, String name) {
		try {
			return Integer.parseInt(request.getParameter(name));
		} catch (Exception e) {
			return null;
		}
	}
	public int getCurrentPage(HttpServletRequest request) {
		try {
			return Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
	}
	
	
	
	@ModelAttribute("isLogined")
	public Boolean isLogined() {
		Boolean isLogined = false;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return true;
		return isLogined;
	}
	@ModelAttribute("userLogined")
	public Users getUserLogined() {
		Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userLogined != null && userLogined instanceof Users)
			return (Users) userLogined;
		return new Users();
	}
}
