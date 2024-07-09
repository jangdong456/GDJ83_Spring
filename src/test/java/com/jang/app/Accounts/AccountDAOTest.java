package com.jang.app.Accounts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jang.app.DefaultTest;
import com.jang.app.accounts.AccountDAO;
import com.jang.app.accounts.AccountDTO;

public class AccountDAOTest extends DefaultTest {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Test
	public void detailTest() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setAccount_number("1720398857208");
		accountDTO.setProduct_id(4);
		
//		assertNotNull(accountDTO);
		
		assertEquals(accountDTO.getAccount_number(), "1720398857208");
	}
}
