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
	
}
