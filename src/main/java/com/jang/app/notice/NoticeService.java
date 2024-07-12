package com.jang.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> list(NoticeDTO noticedto) throws Exception {
		System.out.println("=====List Service ====");
		List<NoticeDTO> ar = noticeDAO.list(noticedto);
		
		return ar;
	}
	
	public void add(NoticeDTO noticeDTO) throws Exception {
		System.out.println("=====Add Service ====");
		noticeDAO.add(noticeDTO);
	}
}
