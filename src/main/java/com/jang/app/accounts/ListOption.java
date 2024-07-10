package com.jang.app.accounts;

public class ListOption {
	
	private Integer product_info_id;
	private Integer order; // 0 desc, 1 asc
	private Integer io; // 0 입금, 1출금 , 그외 전체
	
	public Integer getProduct_info_id() {
		return product_info_id;
	}
	public void setProduct_info_id(Integer product_info_id) {
		this.product_info_id = product_info_id;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Integer getIo() {
		return io;
	}
	public void setIo(Integer io) {
		this.io = io;
	}
	
	
}
