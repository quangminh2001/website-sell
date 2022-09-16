package com.devpro.karma.controller.customer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.Cart;
import com.devpro.karma.dto.CartItem;
import com.devpro.karma.entities.Products;
import com.devpro.karma.services.IProductService;

@Controller
public class CartController extends BaseController {

	@Autowired
	private IProductService iproduct;

	@GetMapping("/cart/view")
	public String viewCartDefault(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) {
		return "customer/cart";
	}

	@PostMapping("/ajax/addToCart")
	public ResponseEntity<Map<String, Object>> addToCard(final Model model, final HttpServletRequest request,
			final HttpServletResponse reponse, final @RequestBody CartItem cartItem) {
		// get session in memory
		HttpSession session = request.getSession();
		// inlitinize cart
		Cart cart = null;
		// if having cart in session is get that cart to controller else set cart into
		// view
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		// get all cartproduct in cart
		List<CartItem> listCartItems = cart.getCartItems();
		// check whatever did cartItem sent having in list Cart item ?
		Boolean isExists = false;
		for (CartItem item : listCartItems) {
			if (cartItem.getProductId().equals(item.getProductId())) {
				isExists = true;
				// add quanlity into old cart product
				item.setQuantity(item.getQuantity() + cartItem.getQuantity());
				if(item.getQuantity() < 1)
					item.setQuantity(1);
			}
		}
		// if cart product is not into this cart, set value for this cart product
		if (isExists == false) {
			Products productInDb = iproduct.findById(cartItem.getProductId());
			cartItem.setProductName(productInDb.getTitle());
			cartItem.setPriceUnit(productInDb.getPriceSale());
			cartItem.setAvatar(productInDb.getAvatar());
			// add cart item into cart
			cart.getCartItems().add(cartItem);
		}
		calculateTotalPrice(request);
		getTotalItems(request);
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("status", 200);
		jsonResponse.put("cartItem", cartItem);
		jsonResponse.put("totalItems", getTotalItems(request));
		session.setAttribute("totalItems", getTotalItems(request));
		
		return ResponseEntity.ok(jsonResponse);
	}

	private void calculateTotalPrice(final HttpServletRequest request) {

		// để lấy session sử dụng thông qua request
		// session tương tự như kiểu Map và được lưu trên main memory.
		HttpSession session = request.getSession();

		// Lấy thông tin giỏ hàng.
		Cart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();
		BigDecimal total = BigDecimal.ZERO;
		
		for(CartItem ci : cartItems) {
			total = total.add(ci.getPriceUnit().multiply(BigDecimal.valueOf(ci.getQuantity())));
		}

		cart.setTotaPrice(total);
		
	}

	private int getTotalItems(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("cart") == null) {
			return 0;
		}
		Cart cart = (Cart) httpSession.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();
		int total = 0;
		for (CartItem item : cartItems) {
			total += item.getQuantity();
		}
		return total;
	}
	
	@PostMapping("/ajax/deleteItemFromCart")
	public ResponseEntity<Map<String, Object>> deleteItemFromCard(final Model model, final HttpServletRequest request,
			final HttpServletResponse reponse, @RequestBody CartItem cartItem) {
		// get session in memory
		HttpSession session = request.getSession();
		// inlitinize cart
		Cart cart = null;
		// if having cart in session is get that cart to controller else set cart into
		// view
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		// get all cartproduct in cart
		List<CartItem> listCartItems = cart.getCartItems();
		// check whatever did cartItem send having in list Cart item ?
		for (CartItem item : listCartItems) {
			if (cartItem.getProductId().equals(item.getProductId())) {
				cartItem = item;
			}
		}
		int totalItems = Integer.parseInt(session.getAttribute("totalItems")+"");
		session.setAttribute("totalItems", totalItems-cartItem.getQuantity());
		listCartItems.remove(cartItem);
		cart.setCartItems(listCartItems);
		calculateTotalPrice(request);
		// if cart product is not into this cart, set value for this cart product
		Map<String, Object> jsonResponse = new HashMap<String, Object>();
		jsonResponse.put("status", 200);
		jsonResponse.put("message", "You deleted this product from cart successfully");
		return ResponseEntity.ok(jsonResponse);
	}
}
