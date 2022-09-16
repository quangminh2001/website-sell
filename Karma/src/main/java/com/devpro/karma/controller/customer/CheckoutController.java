package com.devpro.karma.controller.customer;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.Cart;
import com.devpro.karma.dto.CartItem;
import com.devpro.karma.entities.Products;
import com.devpro.karma.entities.Saleorder;
import com.devpro.karma.entities.SaleorderProduct;
import com.devpro.karma.services.IProductService;
import com.devpro.karma.services.ISaleorderService;

@Controller
public class CheckoutController extends BaseController {
	
	@Autowired
	private ISaleorderService isaleorder;
	
	@Autowired
	private IProductService iproduct;
	
	@RequestMapping(value = { "/cart/checkout" }, method = RequestMethod.GET)
	public String viewChechoutDefault(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return "customer/checkout";
	}

	@RequestMapping(value = { "/cart/checkout" }, method = RequestMethod.POST)
	public String viewChechout(final Model model, final HttpServletRequest request,
								final HttpServletResponse response)
			throws IOException {
		
		String customerName = request.getParameter("fullName");
		String customerEmail = request.getParameter("email");
		String customerAddress = request.getParameter("address");
		String customerPhone = request.getParameter("phonenumber");
		String note = request.getParameter("message");
		
		HttpSession session = request.getSession();
		Cart cart = null;
		Saleorder saleorder = new Saleorder();
		
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		
		saleorder.setCustomerAddress(customerAddress);
		saleorder.setCustomerEmail(customerEmail);
		saleorder.setCustomerName(customerName);
		saleorder.setCustomerPhone(customerPhone);
		saleorder.setNote(note);
		saleorder.setStatusorder("Pending"); 
		
		
		
		for(CartItem  cartIT : cart.getCartItems()) {
			SaleorderProduct saleorderProduct = new SaleorderProduct();
			Products productInDb = iproduct.findById(cartIT.getProductId());
			saleorderProduct.setProducts(productInDb);
			saleorderProduct.setQuality(cartIT.getQuantity());
			saleorder.addSaleorderProduct(saleorderProduct);
		}
		saleorder.setTotal(cart.getTotaPrice());
		isaleorder.saveOrUpdate(saleorder);
		session.setAttribute("cart", null);
		session.setAttribute("totalItems", 0);
		session.setAttribute("totalAllPrice", 0);
		model.addAttribute("status",true);
		model.addAttribute("messageCart","Your order is pending. We will deliver your order as soon as possible");
		return "customer/checkout";
	}
	
}
