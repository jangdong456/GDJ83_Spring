package com.jang.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jang.app.boards.BoardDAO;
import com.jang.app.boards.BoardDTO;
import com.jang.app.boards.BoardService;
import com.jang.app.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		System.out.println("=====List Service ====");
		
		pager.makerow();
		
		long totalCount = boardDAO.getTotalCount(pager);
		
		pager.makeNum(totalCount);
		
		return boardDAO.list(pager);
		
	}
	
	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.update(boardDTO); 
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.delete(boardDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.detail(boardDTO);
	}
}
