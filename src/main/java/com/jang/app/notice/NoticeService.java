package com.jang.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.app.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> list(Pager pager) throws Exception {
		System.out.println("=====List Service ====");
		
		pager.makerow();
		
		long totalCount = noticeDAO.getTotalCount(pager);
		
		pager.makeNum(totalCount);
		
		return noticeDAO.list(pager);
		

	}
	
	public int add(NoticeDTO noticeDTO) throws Exception {
		System.out.println("=====Add Service ====");
		return noticeDAO.add(noticeDTO);
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		System.out.println("=====detail Service ====");
		return noticeDAO.detail(noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		System.out.println("=====update Service ====");
		return noticeDAO.update(noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception {
		System.out.println("==== delete Service ====");
		return noticeDAO.delete(noticeDTO);
	}
}
