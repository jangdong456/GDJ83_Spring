package com.jang.app.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public AccountDTO transfer(AccountDTO accountDTO) throws Exception {
		return accountDAO.transfer(accountDTO);
	}
	
	public int update(AccountDTO accountDTO) throws Exception {
		return accountDAO.update(accountDTO);
	}

}
