package com.devpro.karma.controller.administrator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.ProductSearchModel;
import com.devpro.karma.entities.Products;
import com.devpro.karma.services.IProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController extends BaseController {
	@Autowired
	IProductService iproduct;

	@GetMapping("/product/addorupdate")
	public String defaultProduct(final Model model, final HttpServletRequest request,
			final @RequestParam("id") Optional<Integer> id) {
		Products product = id.isEmpty() ? new Products() : iproduct.findById(id.get());
		model.addAttribute("product", product);
		return "administrator/productadd";
	}

	@PostMapping("/product/addorupdate")
	public String addProduct(final Model model, final HttpServletRequest request,
			final @ModelAttribute("product") Products product, final @RequestParam("avt") MultipartFile mutiFileAVT,
			final @RequestParam("img") MultipartFile[] multipartFile) throws IllegalStateException, IOException {
		iproduct.SaveOrUpdate(product, mutiFileAVT, multipartFile);
		return "redirect:/admin/product/list";
	}

	@GetMapping("/product/list")
	public String listProducts(final Model model, final HttpServletRequest request) {
		ProductSearchModel searchModel = iproduct.findModelSearch(request);
		model.addAttribute("pagerData", iproduct.searchProduct(searchModel, 10));
		model.addAttribute("searchModel", searchModel);
		return "administrator/productlist";
	}

	@PostMapping("/product/list/blockOrActive")
	public ResponseEntity<Map<String, Object>> blockOrActive(final Model model, final HttpServletRequest request,
			@RequestBody Products product) {
		Products pr = iproduct.findById(product.getId());
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("title", pr.getTitle());
		Boolean status = pr.getStatus() == true ? false : true;
		pr.setStatus(status);
		iproduct.save(pr);
		json.put("status", pr.getStatus() == true ? "Active" : "Block");
		return ResponseEntity.ok(json);
	}
}
