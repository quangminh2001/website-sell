package com.devpro.karma.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_coupons")
public class Coupons extends BaseEntity {
	@Column(name = "code", length = 45, nullable = false)
	private String code;

	@Column(name = "reduced_price", precision = 13, scale = 2, nullable = false)
	private BigDecimal reducedPrice;

	@Lob
	@Column(name = "description", nullable = true, columnDefinition = "LONGTEXT")
	private String descriptions;

	@Column(name = "status", nullable = true)
	private Boolean status = Boolean.FALSE;

	@Column(name = "expired_date", nullable = true)
	private Date expiredDate;

	@Column(name = "amount", nullable = false)
	private Integer amount;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users user = new Users();

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getReducedPrice() {
		return reducedPrice;
	}

	public void setReducedPrice(BigDecimal reducedPrice) {
		this.reducedPrice = reducedPrice;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

}
