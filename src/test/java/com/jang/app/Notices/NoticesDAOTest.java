package com.jang.app.Notices;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jang.app.DefaultTest;
import com.jang.app.notice.NoticeDAO;
import com.jang.app.notice.NoticeDTO;
import com.jang.app.product.ProductDTO;

public class NoticesDAOTest extends DefaultTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
	public void addTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		for(int i=0; i<100; i++) {
			noticeDTO.setM_id(10);
			noticeDTO.setBoard_title("테스트" + i);
			noticeDTO.setBoard_contents("아무거나 내용" + i);
			noticeDAO.add(noticeDTO);
		}
		System.out.println("Fisnish");
	}
	

}
