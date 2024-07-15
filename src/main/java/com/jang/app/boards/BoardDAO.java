package com.jang.app.boards;

import java.util.List;

import com.jang.app.util.Pager;

public interface BoardDAO {
	
	// NoticeDAO, QnaDAO
	// 인터페이스는 public abstract 생략가능 -> 기본으로 해줌
	
	// list
	public abstract List<BoardDTO> list(Pager pager) throws Exception;
	
	// add 
	public int add(BoardDTO boardDTO) throws Exception;
	
	//update
	int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	int delete(BoardDTO boardDTO) throws Exception;
	
	//detail
	BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//TotalCount
	public Long getTotalCount(Pager pager) throws Exception;
	
}
