package com.my.pojo;

/**
 * Paging helper class
 */
public class Pager {
	private int curPage;// current page
	private int perPageRows;// number of products in one page
	private int rowCount; // total number of products
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int currentPage) {
		this.curPage = currentPage;
	}
	public int getPerPageRows() {
		return perPageRows;
	}
	public void setPerPageRows(int perPageRows) {
		this.perPageRows = perPageRows;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	// Calculate the total number of pages
	public int getPageCount() {
		return (rowCount + perPageRows - 1) / perPageRows;
	}
	// Get the index of the first product on the current page
	public int getFirstLimitParam() {
		return (this.curPage - 1) * this.perPageRows;
	}
}
