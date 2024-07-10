package com.jang.app.Transfer;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jang.app.DefaultTest;
import com.jang.app.transfers.TransferService;

public class TransferServiceTest extends DefaultTest {
	
	
	@Autowired
	private TransferService transferService;
	
	@Test
	public void transferTest() throws Exception {
//		transferService.trade();
		System.out.println("종료");
	}

}
