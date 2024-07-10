package com.jang.app.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.app.transfers.TransferDTO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	public int add(AccountDTO accountdto) throws Exception {
		return accountDAO.add(accountdto);
	}
	
	public AccountDTO detail(AccountDTO accountdto) throws Exception {
		return accountDAO.detail(accountdto);
	}
	
	
	public List<TransferDTO> list(ListOption listOption) throws Exception {
		return accountDAO.list(listOption);
	}
	


}
