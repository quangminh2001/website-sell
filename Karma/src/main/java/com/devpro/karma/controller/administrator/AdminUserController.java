package com.devpro.karma.controller.administrator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.entities.Roles;
import com.devpro.karma.entities.Users;
import com.devpro.karma.services.UserService;

@Controller
@RequestMapping(value = "/admin/user")
public class AdminUserController extends BaseController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String viewUserDefault(final HttpServletRequest request, final Model model) {
	    List<Users> listUsers =	userService.findAll();
	    List<Users> listUser = new ArrayList<Users>();
	    
	    for(int i = 0; i < listUsers.size(); i++) {
	    	List<Roles> roles = new ArrayList<Roles>(listUsers.get(i).getRoles());
	    	for(int j = 0; j < roles.size(); j++) {
	    		if(roles.get(j).getName().equalsIgnoreCase("Guest")) {
	    			listUser.add(listUsers.get(i));
	    			break;
	    		}
	    	}
	    }		
		model.addAttribute("listUser", listUser);
//		model.addAttribute("searchModel", search);
		return "administrator/userlist";
	}
	
	@PostMapping("/list/blockOrActive")
	public ResponseEntity<Map<String, Object>> blockOrActive(final Model model, final HttpServletRequest request,
			@RequestBody Users users) {
		Users user = userService.findById(users.getId());
		Map<String, Object> json = new HashMap<String, Object>();
		Boolean status = user.getStatus() == false ? true : false;
		user.setStatus(status);
		userService.save(user);
		json.put("status", user.getStatus() == true ? "Active" : "Block");
		return ResponseEntity.ok(json);
	}
}
