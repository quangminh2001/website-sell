package com.devpro.karma.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product_attribute")
public class ProductAttribute extends BaseEntity {
	@Column(name = "status", nullable = true)
	private Boolean status = Boolean.FALSE;

	@Column(name = "attribute_type", nullable = false, length = 45)
	private String attributeType;

	@Column(name = "value", nullable = false, length = 45)
	private String value;

	@Column(name = "plus_price", nullable = false, precision = 13, scale = 2)
	private BigDecimal plusPrice;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Products product = new Products();

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public BigDecimal getPlusPrice() {
		return plusPrice;
	}

	public void setPlusPrice(BigDecimal plusPrice) {
		this.plusPrice = plusPrice;
	}

}
