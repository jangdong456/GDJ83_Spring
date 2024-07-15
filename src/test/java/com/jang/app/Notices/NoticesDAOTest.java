package com.jang.app.Notices;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jang.app.DefaultTest;
import com.jang.app.boards.BoardDTO;
import com.jang.app.boards.notice.NoticeDAO;
import com.jang.app.boards.notice.NoticeDTO;

public class NoticesDAOTest extends DefaultTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void addTest() throws Exception {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		for(int i=0; i<100; i++) {
//			noticeDTO.setM_id(10);
//			noticeDTO.setBoard_title("테스트" + i);
//			noticeDTO.setBoard_contents("아무거나 내용" + i);
//			noticeDAO.add(noticeDTO);
//		}
//		System.out.println("Fisnish");
//	}
	
//	@Test
	public void detailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoard_num(8L);
		BoardDTO dto = noticeDAO.detial(noticeDTO);
		System.out.println("==== detail test ======");
	}
	
//	@Test
	public void listTest() throws Exception {
		
	}
	
	@Test
	public void addTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setBoard_writer(10);
			noticeDTO.setBoard_title("ttttt");
			noticeDTO.setBoard_contents("ttttt");
			noticeDAO.add(noticeDTO);
		
		System.out.println("==== add test ====");
	}
}
