package com.devpro.karma.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.dto.ProductSearchModel;
import com.devpro.karma.entities.Products;
import com.devpro.karma.services.ICommentService;
import com.devpro.karma.services.IProductService;

@Controller
@RequestMapping(value = "/product/detail")
public class DetailProductController {
	@Autowired
	private IProductService iproduct;
	@Autowired
	private ICommentService icomment;
	
	@GetMapping("/{seo}")
	public String detailProduct(final Model model, HttpServletRequest request,final HttpServletResponse response,
			@PathVariable("seo") String seo) {
		ProductSearchModel searchModel = new ProductSearchModel();
		searchModel.setSeo(seo);
		searchModel.setPage(1);
		Products product = iproduct.searchProduct(searchModel, 1).getData().get(0);
		
		ProductSearchModel searchList = new ProductSearchModel();
		searchList.setPage(1);
		searchList.setCategory(product.getCategories().getId());
		model.addAttribute("product",product);
		model.addAttribute("listComments",icomment.findByListComment(product.getId()));
		
		model.addAttribute("listProduct",iproduct.searchProduct(searchList, 9));
		return "customer/single-product";
	}
}
