package com.jang.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.jang.app.accounts.AccountDAO.";
	
	public int add(AccountDTO accountdto) {
		 return sqlSession.insert(NAMESPACE + "add" , accountdto);
	}
}
