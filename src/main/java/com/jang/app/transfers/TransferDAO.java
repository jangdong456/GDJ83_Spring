package com.jang.app.transfers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.app.accounts.AccountDTO;

@Repository
public class TransferDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.jang.app.transfers.TransferDAO.";
	
	//받는 계좌 pk번호
	public AccountDTO find(TransferDTO transferDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "find", transferDTO);
	}
	
	// 입출금 내역
	public int add(TransferDTO transferDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", transferDTO);
	}
	
	// 계좌통장 잔액 업데이트
	public int update(TransferDTO transferDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", transferDTO);
	}
}
