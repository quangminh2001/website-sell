package com.devpro.karma.controller.administrator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.karma.controller.BaseController;

import com.devpro.karma.dto.PostSearchModel;

import com.devpro.karma.entities.Post;
import com.devpro.karma.entities.Users;
import com.devpro.karma.services.ICategoryService;
import com.devpro.karma.services.IPostService;

@Controller
@RequestMapping(value = "/admin/post")
public class AdminPostController extends BaseController {
	@Autowired
	private IPostService iPostService;

	@Autowired
	private ICategoryService icategory;

	@GetMapping("/list")
	public String defaultListCategory(final Model model, final HttpServletRequest request) {
		int page = getCurrentPage(request);
		String keyword = request.getParameter("keyword");
		PostSearchModel search = new PostSearchModel();
		search.setKeyword(keyword);
		search.setCurrentPage(page);
		model.addAttribute("pagerData", iPostService.searchPost(search));
		model.addAttribute("searchModel", search);
		return "/administrator/postlist";
	}

	@GetMapping("/addorupdate")
	public String addOrUpdate(final Model model, final HttpServletRequest request) {
		Post cate = request.getParameter("id") == null ? new Post()
				: iPostService.findById(Integer.parseInt(request.getParameter("id")));
		
		model.addAttribute("post", cate);
		return "administrator/postcreatedorupdate";
	}

	@PostMapping("/addorupdate")
	public String addOrUpdatePost(final Model model, final HttpServletRequest request,
			@ModelAttribute("post") Post post, final @RequestParam("avt") MultipartFile mutiFileAVT) throws IllegalStateException, IOException {
		String message = post.getId() == null ? "You added the category '" + post.getTitle() + "' successfully"
				: "You revised the category '" + post.getTitle() + "' successfully";
		model.addAttribute("message", message);
		Users user = new Users();
		Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userLogined != null && userLogined instanceof Users)
			user = (Users) userLogined;
		post.setUserCreated(user.getUsername());
		iPostService.saveOrUpdate(post, mutiFileAVT);
		model.addAttribute("cate", post);
		return "redirect:/admin/post/list";
	}
//	
	@PostMapping("/list/blockOrActive")
	public ResponseEntity<Map<String, Object>> blockOrActive(final Model model, final HttpServletRequest request,
			@RequestBody Post post) {
		
		System.out.println(post.getId());
		Post pr = iPostService.findById(post.getId());
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("name",pr.getTitle() );
		Boolean status = pr.getStatus() == true ? false : true;
		System.out.println(pr.toString());
		pr.setStatus(status);
		iPostService.save(pr);
		json.put("status", pr.getStatus() == true ? "Active" : "Block");
		return ResponseEntity.ok(json);
	}
}
