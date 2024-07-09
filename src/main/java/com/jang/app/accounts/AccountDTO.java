package com.jang.app.accounts;

import java.sql.Date;

import com.jang.app.members.MemberDTO;
import com.jang.app.product.ProductDTO;

public class AccountDTO {

	private Integer product_info_id;
	private Integer product_id;
	private Integer m_id;
	private Date join_date;
	private String account_number;
	private Integer balance;
	private MemberDTO memberDTO;
	private ProductDTO productDTO;
	
	public Integer getProduct_info_id() {
		return product_info_id;
	}
	public void setProduct_info_id(Integer product_info_id) {
		this.product_info_id = product_info_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	

	
}
