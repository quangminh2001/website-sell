package com.devpro.karma.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.aspectj.weaver.tools.Trace;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tbl_users")
public class Users extends BaseEntity implements UserDetails{
	@Column(name = "username", length = 45, nullable = false)
	private String username;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "email", length = 45, nullable = false)
	private String email;

	@Column(name = "status")
	private Boolean status = Boolean.FALSE;
	@Column(name = "phone", nullable = true, length = 45)
	private String phone;
	@Column(name = "address", nullable = true, length = 100)
	private String address;
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Set<Comments> comments = new HashSet<Comments>();

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Coupons> coupons = new HashSet<Coupons>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
	private Set<Roles> roles = new HashSet<Roles>();

//	public void addComment(Comments comment) {
//		comments.add(comment);
//		comment.setUser(this);
//	}
	public void addRoles(Roles role) {
		role.getUsers().add(this);
		roles.add(role);
	}
	public void addCoupon(Coupons coupon) {
		coupons.add(coupon);
		coupon.setUser(this);
	}

	public Set<Coupons> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupons> coupons) {
		this.coupons = coupons;
	}

//	public Set<Comments> getComments() {
//		return comments;
//	}
//
//	public void setComments(Set<Comments> comments) {
//		this.comments = comments;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
