package com.devpro.karma.controller.administrator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.CouponSearch;
import com.devpro.karma.services.ICouponService;

@Controller
@RequestMapping(value = "/admin/coupons")
public class AdminCouponController extends BaseController {
	@Autowired
	private ICouponService icouponService;

	@GetMapping("/list")
	public String couponDefault(final HttpServletRequest request, final Model model) {
		int page = getCurrentPage(request);
		String keyword = request.getParameter("keyword");
		String status = request.getParameter("status");
		CouponSearch couponSearch = new CouponSearch();
		couponSearch.setKeyword(keyword);
		couponSearch.setPage(page);
		model.addAttribute("pagerData", icouponService.search(couponSearch));
		model.addAttribute("searchModel", couponSearch);
		return "/administrator/couponlist";
	}
}
