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
	

	// maperr에서 if문 사용한후의 변환 코드
	public int trade(TransferDTO transferDTO)throws Exception {
		// 1번 계좌에서 5000을 1720369109171 계좌로 이체
		// 보내는 계좌
		// 잔액이 보내는 값보다 작을 때
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setProduct_info_id(transferDTO.getProduct_info_id());
		System.out.println("===== Service ====");
		accountDTO.setAccount_number(transferDTO.getReceiveNumber());
		
//		accountDTO = accountDAO.detail(accountDTO);
		
		AccountDTO userNum = transferDAO.find(transferDTO);
//		System.out.println(userNum.getProduct_info_id());
		
// 		parameter 계좌번호 필요
//		if(accountDTO.getBalance() < transferDTO.getBalance()) {
//			System.out.println("돈 부족");
//			return 0;
//		}
		
		//1. 거래내역 추가
		transferDTO.setType("출금");

		int result = transferDAO.add(transferDTO);

		
//		//2. 출금 계좌 내용을 업데이트
		result = transferDAO.update(transferDTO);
//		
//		//3.받는 dto 수정

		
//		//4. 받는 계좌 거래내역 추가
		System.out.println("4. 받는 계좌 거래내역 추가");
		transferDTO.setProduct_info_id(userNum.getProduct_info_id()); //받는 계좌 product_info_id = pk번호
		transferDTO.setType("입금");
		result = transferDAO.add(transferDTO);
//		
//		//5. 받는 계좌내용을 업데이트
		System.out.println("5. 받는 계좌내용을 업데이트");
		result = transferDAO.update(transferDTO);
		
		return result;
	}
}
