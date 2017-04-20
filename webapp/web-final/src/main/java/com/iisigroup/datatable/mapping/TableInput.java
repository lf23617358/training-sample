package com.iisigroup.datatable.mapping;

public class TableInput<T> {
	private int limit;
	private int offset;
	private String order;
	private String sort;
	private T rqObj;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public T getRqObj() {
		return rqObj;
	}

	public void setRqObj(T rqObj) {
		this.rqObj = rqObj;
	}

}
