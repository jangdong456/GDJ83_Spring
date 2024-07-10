package com.jang.app.transfers;

import java.sql.Date;
import java.util.List;

import com.jang.app.accounts.AccountDTO;

public class TransferDTO {
	//거래번호
	private Integer history_id;
	
	// 계좌테이블 pk번호
	private Integer product_info_id;
	
	//거래일
	private Date history_time;
	
	// 거래금액
	private Integer amount;
	
	//거래시 잔액
	private Integer balance;
	
	// 거래시 입출금 구분 (0:입금, 1:출금) | ()
	private String type;
	
	//받는계좌번호
	private Integer receiveNumber;
	
	public Integer getReceiveNumber() {
		return receiveNumber;
	}
	public void setReceiveNumber(Integer receiveNumber) {
		this.receiveNumber = receiveNumber;
	}
	// 계좌테이블 dto
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
