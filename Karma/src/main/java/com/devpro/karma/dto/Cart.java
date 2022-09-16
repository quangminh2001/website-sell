package com.devpro.karma.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	private BigDecimal totaPrice = BigDecimal.ZERO;
	private List<CartItem> cartItems = new ArrayList<>();

	public BigDecimal getTotaPrice() {
		return totaPrice;
	}

	public void setTotaPrice(BigDecimal totaPrice) {
		this.totaPrice = totaPrice;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}
