package com.devpro.karma.dto;

public class ProductSearchModel {
	public String keyword;
	public Integer page;
	public Integer category;
	public Integer isHot;
	public Boolean isBestSelling = Boolean.FALSE;
	public Boolean isNewest = Boolean.FALSE;
	public String seo;
	public Integer year;
	public String sortByPrice;
	public String sortByStatus;
	public String discountProduct;
	public String getDiscountProduct() {
		return discountProduct;
	}

	public void setDiscountProduct(String discountProduct) {
		this.discountProduct = discountProduct;
	}

	public String getSortByStatus() {
		return sortByStatus;
	}

	public void setSortByStatus(String sortByStatus) {
		this.sortByStatus = sortByStatus;
	}

	public String getSortByPrice() {
		return sortByPrice;
	}

	public void setSortByPrice(String sortByPrice) {
		this.sortByPrice = sortByPrice;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Boolean getIsBestSelling() {
		return isBestSelling;
	}

	public void setIsBestSelling(Boolean isBestSelling) {
		this.isBestSelling = isBestSelling;
	}

	public Boolean getIsNewest() {
		return isNewest;
	}

	public void setIsNewest(Boolean isNewest) {
		this.isNewest = isNewest;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

}
