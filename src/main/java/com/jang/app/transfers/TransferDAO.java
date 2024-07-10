package com.jang.app.transfers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransferDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.jang.app.transfers.TransferDAO.";
	
	// 입출금 내역
	public int add(TransferDTO transferDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", transferDTO);
	}
	
	public int update(TransferDTO transferDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", transferDTO);
	}
}
