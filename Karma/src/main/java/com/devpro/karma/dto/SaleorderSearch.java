package com.devpro.karma.dto;

public class SaleorderSearch {
	public String keyword;
	public Integer currentPage;
	public String status;
	public String byYear;
	public String byMonth;

	public String getByYear() {
		return byYear;
	}

	public void setByYear(String byYear) {
		this.byYear = byYear;
	}

	public String getByMonth() {
		return byMonth;
	}

	public void setByMonth(String byMonth) {
		this.byMonth = byMonth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

}
