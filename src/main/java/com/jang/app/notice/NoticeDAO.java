package com.jang.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPAVE = "com.jang.app.notice.NoticeDAO.";
	
	public List<NoticeDTO> list(NoticeDTO noticedto) throws Exception {
		System.out.println("=====List DAO ====");
		return sqlSession.selectList(NAMESPAVE + "list", noticedto);
	}
	
	public void add(NoticeDTO noticeDTO) throws Exception {
		System.out.println("=====Add DAO ====");
		sqlSession.insert(NAMESPAVE + "add", noticeDTO);
	}
	
	
}
