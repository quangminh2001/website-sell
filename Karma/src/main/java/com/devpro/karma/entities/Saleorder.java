package com.devpro.karma.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_saleorder")
public class Saleorder extends BaseEntity {
	@Column(name = "code", length = 45, nullable = false)
	private String code;

	@Column(name = "total", precision = 13, scale = 2, nullable = true)
	private BigDecimal total;

	@Column(name = "status", nullable = true)
	private Boolean status = Boolean.FALSE;

	@Column(name = "customer_name", length = 100, nullable = true)
	private String customerName;

	@Column(name = "customer_address", length = 100, nullable = true)
	private String customerAddress;

	@Column(name = "seo", length = 200, nullable = true)
	private String seo;

	@Column(name = "customer_phone", length = 100, nullable = true)
	private String customerPhone;

	@Column(name = "customer_email", length = 100, nullable = true)
	private String customerEmail;

	@Column(name = "note", length = 200, nullable = true)
	private String note;

	@Column(name = "statusorder", length = 200)
	private String statusorder;

	public String getStatusorder() {
		return statusorder;
	}

	public void setStatusorder(String statusorder) {
		this.statusorder = statusorder;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToMany(mappedBy = "saleorder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<SaleorderProduct> saleorderProducts = new HashSet<SaleorderProduct>();

	public void addSaleorderProduct(SaleorderProduct saleorderProduct) {
		saleorderProducts.add(saleorderProduct);
		saleorderProduct.setSaleorder(this);
	}

	public Set<SaleorderProduct> getSaleorderProducts() {
		return saleorderProducts;
	}

	public void setSaleorderProducts(Set<SaleorderProduct> saleorderProducts) {
		this.saleorderProducts = saleorderProducts;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

}
