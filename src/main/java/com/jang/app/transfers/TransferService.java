package com.jang.app.transfers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
	
	@Autowired
	private TransferDAO transferDAO;
	
	public int trade(TransferDTO transferDTO)throws Exception {
		// 1번 계좌에서 5000을 1720369109171 계좌로 이체
		// 보내는 계좌
		
//		transferDTO.setProduct_info_id(1);
		transferDTO.setAmount(transferDTO.getAmount()*-1);
		transferDTO.setType("출금");
		
		//거래내역 추가
		int result = transferDAO.add(transferDTO);
		
		// 계좌 내용을 업데이트
		result = transferDAO.update(transferDTO);
		
		//받는 dto 수정
		transferDTO.setProduct_info_id(2);
		transferDTO.setAmount(transferDTO.getAmount()*-1);
		transferDTO.setType("입금");
		
		
		//계좌 거래내역 추가
		result = transferDAO.add(transferDTO);
		
		// 받는 계좌내용을 업데이트
		result = transferDAO.update(transferDTO);
		
		return result;
	}
}
