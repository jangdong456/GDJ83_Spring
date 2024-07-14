package com.jang.app.notice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.app.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public Map<String, Object> list(NoticeDTO noticedto, Long page, String kind, String search) throws Exception {
		System.out.println("=====List Service ====");
		if(page == null) {
			page = 1L;
		}
		
		if(page < 1) {
			page = 1L;
		}
		
		if(search == null) {
			search = "";
		}
		
		// 0. 한페이지 10개씩 리스트 보여지게 하기
		long perPage = 10L;
		long startRow = (page-1) * perPage + 1;
		long lastRow = page * perPage;
		
		List<Long> ar = new ArrayList<Long>();
		ar.add(startRow);
		ar.add(lastRow);
		
		Pager pager = new Pager();
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		pager.setKind(kind);
		pager.setSearch(search);
		
		// 1. 총 갯수로 총페이지수 구하기
		long totalCount = noticeDAO.getTotalCount(pager);
		long totalPage = totalCount / perPage;
		
		if(totalCount % perPage != 0) {
			totalPage++;
		}
		
		// 2.총 페이지수로 총블럭수 구하기
		long perBlock = 5L;
		long totalBlock = 0; 
		
		totalBlock = totalPage / perBlock; 
		
		if(totalPage % perBlock !=0) {
			totalBlock++;
		}
		
		// 3.현재 페이지 번호로 현재 블럭 번호를 구하기
		long curBlock =0;
		curBlock = page/perBlock;
		
		if(page % perBlock != 0) {
			curBlock++;
		}
		
		//4.현재 블럭 번호로 시작번호와 끝 번호 구하기
		long startNum = (curBlock-1)*perBlock+1;
		long lastNum = curBlock * perBlock;
		
		//5. 이전블록과 다음 블럭 유무 판단
		boolean pre = true;
		boolean next = true;
		
		if(curBlock == 1) {
			pre = false;
		}
		
		if(curBlock == totalBlock) {
			next = false;
			
			lastNum = totalPage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", noticeDAO.list(pager));
		map.put("totalPage" , totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);
		map.put("kind", kind);
		map.put("search", search);
		
		return map;
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
