package com.devpro.karma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_post")
public class Post extends BaseEntity {
	@Column(name = "title", length = 200, nullable = false)
	private String title;
	@Column(name = "view")
	private Integer view = 1;
	@Lob
	@Column(name = "content", columnDefinition = "LONGTEXT", nullable = false)
	private String content;
	@Column(name = "path", length = 200, nullable = false)
	private String path;
	@Column(name = "status")
	private Boolean status = Boolean.FALSE;
	@Column(name = "seo", length = 500)
	private String seo;
	@Column(name = "user_created", length = 145)
	private String userCreated;
	@Column(name = "short_content", length = 2000)
	private String shortContent;
	@Column(name = "category_name", length = 200)
	private String categoryName;

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSeo() {
		return seo;
	}

	public String getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
