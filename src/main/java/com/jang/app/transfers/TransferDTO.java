package com.jang.app.transfers;

import java.sql.Date;
import java.util.List;

import com.jang.app.accounts.AccountDTO;

public class TransferDTO {
	
	private Integer history_id;
	private Integer product_info_id;
	private Date history_time;
	private Integer amount;
	private Integer balance;
	private String type;
	private List<AccountDTO> dto;
	
	public List<AccountDTO> getDto() {
		return dto;
	}
	public void setDto(List<AccountDTO> dto) {
		this.dto = dto;
	}
	public Integer getHistory_id() {
		return history_id;
	}
	public void setHistory_id(Integer history_id) {
		this.history_id = history_id;
	}
	public Integer getProduct_info_id() {
		return product_info_id;
	}
	public void setProduct_info_id(Integer product_info_id) {
		this.product_info_id = product_info_id;
	}
	public Date getHistory_time() {
		return history_time;
	}
	public void setHistory_time(Date history_time) {
		this.history_time = history_time;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
