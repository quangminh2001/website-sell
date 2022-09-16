package com.devpro.karma.controller.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.controller.BaseController;

@Controller
@RequestMapping("/admin/coupon")
public class CouponController extends BaseController {
	@GetMapping("/list")
	public String defaultCoupon(final HttpServletRequest request, final Model model) {
		
		
		
		return "couponlist";
	}
}
