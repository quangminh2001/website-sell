package com.devpro.karma.dto;

import com.devpro.karma.entities.Products;

public class SaleorderProductCustom {
	private Integer productId;
	private Integer count;

	public Integer getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "SaleorderProductCustom [productId=" + productId + ", count=" + count + "]";
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public SaleorderProductCustom(Integer productId, Integer count) {
		super();
		this.productId = productId;
		this.count = count;
	}

}
