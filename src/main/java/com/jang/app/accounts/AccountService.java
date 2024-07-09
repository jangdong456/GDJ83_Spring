package com.jang.app.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.app.members.MemberDTO;
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
	
	public int transfer(MemberDTO memberDTO, TransferDTO transferDTO) throws Exception {
		return accountDAO.transfer(transferDTO);
	}
	
	public int update(AccountDTO accountDTO) throws Exception {
		return accountDAO.update(accountDTO);
	}

}
