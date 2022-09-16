package com.devpro.karma.controller.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.PostSearchModel;
import com.devpro.karma.entities.Post;
import com.devpro.karma.services.IPostService;

@Controller

public class BlogController extends BaseController {
	@Autowired
	private IPostService ipostService;
	
	@GetMapping("/blog")
	public String viewBlog(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		PostSearchModel searchModel = new PostSearchModel();
		searchModel.setCurrentPage(1);
		String search = request.getParameter("search");
		String category = request.getParameter("category");
//		category = category.replaceAll("-", " ");
		System.out.println(category);
		searchModel.setCategory(category);
		searchModel.setKeyword(search);
		searchModel.setStatus("true");
		model.addAttribute("search",ipostService.searchPost(searchModel));
		model.addAttribute("modelsearch", searchModel);
		return "customer/blog";
	}
	
	@GetMapping("single-blog/{seo}")
	public String viewSingleBlog(final Model model,
								@PathVariable("seo") String seo,
								final HttpServletRequest request) {
		Post post = ipostService.findBySeo(seo); 
//		post.setView(post.getView()+1);
//		ipostService.save(post);
		model.addAttribute("post", post);
		return "customer/single-blog";
	}
}
