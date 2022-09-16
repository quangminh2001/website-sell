package com.devpro.karma.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_saleorder_products")
public class SaleorderProduct extends BaseEntity {
	@Column(name = "quality", nullable = false)
	private Integer quality;
	@Column(name = "status", nullable = true)
	private Boolean status = Boolean.FALSE;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "saleorder_id")
	private Saleorder saleorder = new Saleorder();
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Products product = new Products();

	public Products getProducts() {
		return product;
	}

	public void setProducts(Products products) {
		this.product = products;
	}

	public Saleorder getSaleorder() {
		return saleorder;
	}

	public void setSaleorder(Saleorder saleorder) {
		this.saleorder = saleorder;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
