package com.devpro.karma.controller.administrator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.CategorySearchModel;
import com.devpro.karma.entities.Categories;
import com.devpro.karma.entities.Products;
import com.devpro.karma.services.ICategoryService;

@Controller
@RequestMapping(value = "/admin/category")
public class AdminCategoryController extends BaseController {

	@Autowired
	private ICategoryService icategory;

	@GetMapping("/list")
	public String defaultListCategory(final Model model, final HttpServletRequest request) {
		int page = getCurrentPage(request);
		String keyword = request.getParameter("keyword");
		String status = request.getParameter("status");
		CategorySearchModel categorySearch = new CategorySearchModel();
		categorySearch.setKeyword(keyword);
		categorySearch.setPage(page);
		categorySearch.setStatus(status);
		model.addAttribute("pagerData", icategory.searchCategory(categorySearch));
		model.addAttribute("searchModel", categorySearch);
		return "/administrator/categorylist";
	}

	@GetMapping("/addorupdate")
	public String addOrUpdate(final Model model, final HttpServletRequest request) {
		Categories cate = request.getParameter("id") == null ? new Categories()
				: icategory.findById(Integer.parseInt(request.getParameter("id"))).get();
		model.addAttribute("cate", cate);
		return "administrator/categoryaddorupdate";
	}

	@PostMapping("/addorupdate")
	public String addOrUpdatePost(final Model model, final HttpServletRequest request,
			@ModelAttribute("cate") Categories category) {
		String message = category.getId() == null ? "You added the category '" + category.getName() + "' successfully"
				: "You revised the category '" + category.getName() + "' successfully";
		model.addAttribute("message", message);
		icategory.saveOrUpdate(category);
		model.addAttribute("cate", category);
		return "redirect:/admin/category/list";
	}
	@PostMapping("/list/blockOrActive")
	public ResponseEntity<Map<String, Object>> blockOrActive(final Model model, final HttpServletRequest request,
			@RequestBody Categories categories) {
		Categories pr = icategory.findById(categories.getId()).get();
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("name",pr.getName() );
		Boolean status = pr.getStatus() == true ? false : true;
		pr.setStatus(status);
		System.out.println("Gekki"+status);
		pr.getProducts().forEach(p -> p.setStatus(status));
		icategory.save(pr);
		json.put("status", pr.getStatus() == true ? "Active" : "Block");
		return ResponseEntity.ok(json);
	}
}
