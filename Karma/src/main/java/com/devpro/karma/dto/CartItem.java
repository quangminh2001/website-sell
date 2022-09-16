package com.devpro.karma.dto;

import java.math.BigDecimal;

public class CartItem {
	private Integer productId;
	private String productName;
	private String avatar;
	private Integer quantity;
	private BigDecimal priceUnit;
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(BigDecimal priceUnit) {
		this.priceUnit = priceUnit;
	}
	
}
