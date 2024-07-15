package com.jang.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.app.util.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPAVE = "com.jang.app.boards.notice.NoticeDAO.";
	
	public List<NoticeDTO> list(Pager pager) throws Exception {
		System.out.println("=====List DAO ====");
		return sqlSession.selectList(NAMESPAVE + "list",pager);
	}
	
	public int add(NoticeDTO noticeDTO) throws Exception {
		System.out.println("=====Add DAO ====");
		return sqlSession.insert(NAMESPAVE + "add", noticeDTO);
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		System.out.println("=====detail DAO ====");
		return sqlSession.selectOne(NAMESPAVE + "detail", noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		System.out.println("===== update DAO ====");
		return sqlSession.update(NAMESPAVE + "update", noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception {
		System.out.println("==== delete DAO ====");
		return sqlSession.delete(NAMESPAVE + "delete", noticeDTO);
	}
	
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPAVE + "getTotalCount", pager);
	}
	
}
