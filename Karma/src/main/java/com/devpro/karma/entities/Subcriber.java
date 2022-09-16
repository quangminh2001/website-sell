package com.devpro.karma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_subcriber")
public class Subcriber extends BaseEntity{
	@Column(name = "email",length = 200)
	private String email;
}
