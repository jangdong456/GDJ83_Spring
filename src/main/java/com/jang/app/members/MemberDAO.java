package com.jang.app.members;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.jang.app.members.MemberDAO.";
	
	public int join(MemberDTO memberDTO) throws Exception {
		System.out.println("dao@@@@@@");
		return sqlSession.insert(NAMESPACE +"join", memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "login", memberDTO);
	}
	
	
	public int update(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", memberDTO);
	}
	
	public int delete(MemberDTO memberDTO) throws Exception{
		return sqlSession.delete(NAMESPACE + "delete", memberDTO);
	}
	
}
