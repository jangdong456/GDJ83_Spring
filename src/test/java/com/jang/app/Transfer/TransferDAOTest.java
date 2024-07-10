package com.jang.app.Transfer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jang.app.DefaultTest;
import com.jang.app.transfers.TransferDAO;
import com.jang.app.transfers.TransferDTO;

public class TransferDAOTest extends DefaultTest {
	
	@Autowired
	private TransferDAO transferDAO;
	
	@Autowired
	private TransferDTO transferDTO;
	
	//객체가 시작되기전에
	@BeforeClass
	public static void beforeClass() {
		
	}
	
	//테스트 메서드 실행전에 각각 실행
	@Before
	public void before() {
		this.transferDTO = new TransferDTO();
		transferDTO.setProduct_info_id(1);
		transferDTO.setAmount(5000);
		transferDTO.setType("입금");
	}

	
	//@Test
	public void addTest() throws Exception {
		int result = transferDAO.add(transferDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void updateTest() throws Exception {
		int result = transferDAO.update(transferDTO);
		assertNotEquals(0, result);
	}
	
	@After
	public void after() {
		transferDTO = null;
	}

}
