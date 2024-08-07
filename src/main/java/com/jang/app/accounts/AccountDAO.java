package com.jang.app.accounts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.app.transfers.TransferDTO;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.jang.app.accounts.AccountDAO."; // 뒤에 .은 Mapper.xml에서 id값을 쓰기위해서
	
	public int add(AccountDTO accountdto) throws Exception {
		 return sqlSession.insert(NAMESPACE + "add" , accountdto);
	}
	
	// 계좌의 모든정보와 상품명, 이자율 출력
	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);
	}
	
	public List<TransferDTO> list(ListOption listOption) throws Exception {
		return sqlSession.selectList(NAMESPACE + "list", listOption);
	}
}
