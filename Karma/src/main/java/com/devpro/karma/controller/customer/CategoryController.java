package com.devpro.karma.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.CategorySearchModel;
import com.devpro.karma.dto.ProductSearchModel;
import com.devpro.karma.entities.Categories;
import com.devpro.karma.entities.Products;
import com.devpro.karma.services.ICategoryService;
import com.devpro.karma.services.IProductService;
import com.devpro.karma.services.implement.PagerData;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController{
	@Autowired
	private ICategoryService icategory;
	@Autowired
	private IProductService iproduct;

	@ModelAttribute("ProductDiscout")
	public PagerData<Products> productDiscout(){
		ProductSearchModel searchByDiscout = new ProductSearchModel();
		searchByDiscout.setPage(1);
		searchByDiscout.setDiscountProduct("true");
		return iproduct.searchProduct(searchByDiscout, 9);
	}
	
	@GetMapping("")
	public String viewCategoryDefault(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		ProductSearchModel searchModel = new ProductSearchModel();
		Integer page = getCurrentPage(request);
		searchModel.setPage(page);
		String keyword = request.getParameter("search");
		searchModel.setKeyword(keyword);
		model.addAttribute("pageWithData",iproduct.searchProduct(searchModel, 20));
		model.addAttribute("numberPage",20);
		
		return "customer/category";
	}
	@GetMapping("/search")
	public String searchProduct(final Model model, final HttpServletRequest request) {
		Integer categoryID = StringUtils.isEmpty(request.getParameter("categoryID")) ? null : Integer.parseInt(request.getParameter("categoryID"));
		String priceSort = request.getParameter("priceSort");
		Integer year = StringUtils.isEmpty(request.getParameter("year")) ? null : Integer.parseInt(request.getParameter("year"));
		Integer isHot = StringUtils.isEmpty(request.getParameter("ishot")) ? null : 1;
		Integer numberPerPage = StringUtils.isEmpty(request.getParameter("numberPerPage")) ? 20 : Integer.parseInt(request.getParameter("numberPerPage"));
		Integer page = getCurrentPage(request);
		ProductSearchModel searchModel = new ProductSearchModel();
		searchModel.setCategory(categoryID);
		searchModel.setSortByPrice(priceSort);
		
		searchModel.setYear(year);
		searchModel.setIsHot(isHot);
		searchModel.setPage(page);
		PagerData<Products> pager = iproduct.searchProduct(searchModel, numberPerPage);
		model.addAttribute("pageWithData",pager);
		model.addAttribute("numberPage",numberPerPage);
		model.addAttribute("searchModel",searchModel);
		
		
		return "customer/category";
	}
}
