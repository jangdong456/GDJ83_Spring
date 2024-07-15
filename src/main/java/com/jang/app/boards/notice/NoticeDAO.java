package com.jang.app.boards.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.app.boards.BoardDAO;
import com.jang.app.boards.BoardDTO;
import com.jang.app.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.jang.app.boards.notice.NoticeDAO.";
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		System.out.println("=====List DAO ====");
		return sqlSession.selectList(NAMESPACE + "list", pager);
	}
	
	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		System.out.println("=====Add DAO ====");
		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}
	
	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", boardDTO);
	}
	
	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		System.out.println("===== update DAO ====");
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}
	
	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		System.out.println("==== delete DAO ====");
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
	}
	
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}
	
}
