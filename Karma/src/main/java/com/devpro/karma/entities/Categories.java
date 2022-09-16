package com.devpro.karma.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// lack of selfjoin
@Entity
@Table(name = "tbl_category")
public class Categories extends BaseEntity {
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "description", length = 100, nullable = false)
	private String description;
	
	@Column(name = "parent_id", nullable = true)
	private Integer parentId;
	
	@Column(name = "status")
	private Boolean status = Boolean.FALSE;
	
	@Column(name = "seo", length = 1000, nullable = true)
	private String seo;
	
	@OneToMany(mappedBy = "categories",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Products> products = new HashSet<Products>();
	
	public void addProduct(Products product) {
		products.add(product);// used to add product into category
		product.setCategories(this);
	}
	
	public void deleteProduct(Products product) {
		products.remove(product);
		product.setCategories(null);
	}
	
	public Set<Products> getProducts() {
		return products;
	}
	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}
	
}
