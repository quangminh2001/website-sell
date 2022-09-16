
package com.devpro.karma.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;

@Entity
@Table(name = "tbl_comment")
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "created_date", nullable = true)
	private Date createdDate;

	@Lob
	@Column(name = "content", columnDefinition = "LONGTEXT", nullable = true)
	private String content;

	@Column(name = "customer_name", length = 100, nullable = true)
	private String customerName;

	@Column(name = "customer_email", length = 45, nullable = true)
	private String customerEmail;

	@Column(name = "customer_phone", length = 15, nullable = true)
	private String customerPhone;

	@ManyToOne(fetch = FetchType.EAGER)
	private Comments parent;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
	private  Set<Comments> child  = new HashSet<Comments>();
	
	public void addChildComment(Comments comments) {
		child.add(comments);
		comments.setParent(this);
	}
	
	public Comments getParent() {
		return parent;
	}

	public void setParent(Comments parent) {
		this.parent = parent;
	}

	public Set<Comments> getChild() {
		return child;
	}

	public void setChild(Set<Comments> child) {
		this.child = child;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Products product = new Products();

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id")
//	private Users user = new Users();

//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
