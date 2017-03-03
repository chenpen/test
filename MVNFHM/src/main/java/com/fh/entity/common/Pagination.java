package com.fh.entity.common;

import java.io.Serializable;

public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 页数
	 */
	private int pageNum;
	
	/**
	 * 对应mysql中的行号下标
	 */
	private int pageIndex;

	/**
	 * 每页行数
	 */
	private int pageSize;

	/**
	 * 排序列字段名
	 */
	private String sort;

	/**
	 * 排序方式，可以是 'asc'  'desc'，默认'asc'
	 */
	private String order;

	public Pagination() {

	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}



	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 计算从第几行
	 */
	public void initPageIndex() {
		this.pageIndex = (pageNum - 1) * pageSize;
	}

}
