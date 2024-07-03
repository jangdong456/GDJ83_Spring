package com.jang.app.product;

public class ProductDTO {

	private Integer product_id;
	private String product_type;
	private double product_rate;
	private String product_detail;
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public double getProduct_rate() {
		return product_rate;
	}
	public void setProduct_rate(double product_rate) {
		this.product_rate = product_rate;
	}
	public String getProduct_detail() {
		return product_detail;
	}
	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}
	
}
