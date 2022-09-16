package com.devpro.karma.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.ProductSearchModel;
import com.devpro.karma.entities.Products;
import com.devpro.karma.services.CustomService;
import com.devpro.karma.services.IProductService;
import com.devpro.karma.services.implement.PagerData;

@Controller
public class HomeController extends BaseController {
	@Autowired
	private IProductService iproduct;

	@Autowired
	private CustomService customService;

	@ModelAttribute("producthot")
	public PagerData<Products> productHot() {
		ProductSearchModel searchByDiscout = new ProductSearchModel();
		searchByDiscout.setPage(1);
		searchByDiscout.setIsHot(0);
		return iproduct.searchProduct(searchByDiscout, 9);
	}
	
	@ModelAttribute("productBestSell")
	public List<Products> bestSellProduct(){
		return customService.search();
	}
	@RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
	public String viewDefault(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		ProductSearchModel newestProducts = new ProductSearchModel();
		newestProducts.setIsNewest(true);
		newestProducts.setPage(1);
		newestProducts.setSortByStatus("true");
		model.addAttribute("listProductNew", iproduct.searchProduct(newestProducts, 8).getData());
		return "customer/index";
	}

//	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
//	public String viewLoginDefault(final Model model, final HttpServletRequest request,
//			final HttpServletResponse response) throws IOException {
//		return "customer/login";
//	}

	@RequestMapping(value = { "/confirmation" }, method = RequestMethod.GET)
	public String viewConfirmationDefault(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return "customer/confirmation";
	}

	@RequestMapping(value = { "/single-blog" }, method = RequestMethod.GET)
	public String viewSingeBloDefault(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return "customer/single-blog";
	}

	@RequestMapping(value = { "/single-product" }, method = RequestMethod.GET)
	public String viewSinglePrDefault(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return "customer/single-product";
	}

	@RequestMapping(value = { "/tracking" }, method = RequestMethod.GET)
	public String viewTrackingDefault(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return "customer/tracking";
	}

}
