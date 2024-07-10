package com.jang.app.transfers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.app.accounts.AccountDAO;
import com.jang.app.accounts.AccountDTO;

@Service
public class TransferService {
	
	@Autowired
	private TransferDAO transferDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
//	public int trade(TransferDTO transferDTO)throws Exception {
//		// 1번 계좌에서 5000을 1720369109171 계좌로 이체
//		// 보내는 계좌
//		
//		
//		// ===============
//		// 잔액이 보내는 값보다 작을 때
//		AccountDTO accountDTO = new AccountDTO();
//		accountDTO.setProduct_info_id(transferDTO.getProduct_info_id());
//	
//		accountDTO = accountDAO.detail(accountDTO);
//		if(accountDTO.getBalance() < transferDTO.getBalance()) {
//			return 0;
//		}
//		
//		transferDTO.setProduct_info_id(1);
//		transferDTO.setAmount(transferDTO.getAmount()*-1);
//		transferDTO.setType("출금");
//		
//		//거래내역 추가
//		int result = transferDAO.add(transferDTO);
//		
//		// 계좌 내용을 업데이트
//		result = transferDAO.update(transferDTO);
//		
//		//받는 dto 수정
//		transferDTO.setProduct_info_id(2);
//		transferDTO.setAmount(transferDTO.getAmount()*-1);
//		transferDTO.setType("입금");
//		
//		
//		//계좌 거래내역 추가
//		result = transferDAO.add(transferDTO);
//		
//		// 받는 계좌내용을 업데이트
//		result = transferDAO.update(transferDTO);
//		
//		return result;
//	}
	
	// maperr에서 if문 사용한후의 변환 코드
	public void trade(TransferDTO transferDTO)throws Exception {
		// 1번 계좌에서 5000을 1720369109171 계좌로 이체
		// 보내는 계좌
		
	
		// ===============
		// 잔액이 보내는 값보다 작을 때
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setProduct_info_id(transferDTO.getProduct_info_id());

	
		accountDTO = accountDAO.detail(accountDTO);
		System.out.println("=====================");
		System.out.println(accountDTO.getProduct_info_id());
		
//		if(accountDTO.getBalance() < transferDTO.getBalance()) {
////			return 0;
//		}
		
//		transferDTO.setProduct_info_id(1);
//		transferDTO.setAmount(transferDTO.getAmount()*-1);
//		transferDTO.setType("출금");
		
		//거래내역 추가
		transferDTO.setType("입금");
		int result = transferDAO.add(transferDTO);
//		
//		// 계좌 내용을 업데이트
//		result = transferDAO.update(transferDTO);
//		
//		//받는 dto 수정
//		transferDTO.setProduct_info_id(2);
//		transferDTO.setAmount(transferDTO.getAmount()*-1);
//		transferDTO.setType("입금");
//		
//		
//		//계좌 거래내역 추가
//		result = transferDAO.add(transferDTO);
//		
//		// 받는 계좌내용을 업데이트
//		result = transferDAO.update(transferDTO);
//		
	}
}
