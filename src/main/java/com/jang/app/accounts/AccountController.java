package com.jang.app.accounts;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jang.app.members.MemberDTO;
import com.jang.app.members.MemberService;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private MemberService memberService;
	
//	@Autowired
//	private TransferService transferService;
	
	@RequestMapping(value= "add", method = RequestMethod.GET)
	public String add(HttpSession session, AccountDTO accountdto, Model model) throws Exception {
		Calendar ca = Calendar.getInstance();
		
		long num = ca.getTimeInMillis();
		String accountNum = String.valueOf(num);
			
		MemberDTO memberdto = (MemberDTO)session.getAttribute("member");
		
		System.out.println("로그인 id: " + memberdto.getM_id());

		accountdto.setM_id(memberdto.getM_id());
		accountdto.setAccount_number(accountNum);
		accountdto.setBalance(0);
		
		
		String url = "commons/message";
		
		int result = accountService.add(accountdto);
		if(result > 0) {
			url = "redirect:/";
		} else {
			model.addAttribute("resutl", "계좌발급 실패");	
		}
		return url;
	}
	
	@RequestMapping(value= "detail", method = RequestMethod.GET)
	public void detail(AccountDTO accountDTO, Model model) throws Exception {
		accountDTO = accountService.detail(accountDTO);

		if (accountDTO != null) {

			model.addAttribute("dto", accountDTO);
		}
	}
	
	@RequestMapping(value="transfer", method= RequestMethod.GET)
	public void transfer(AccountDTO accountDTO, Model model) throws Exception {
//		accountDTO = accountService.detail(accountDTO);
//		model.addAttribute("accountNum",accountDTO);
	}
	
//	@RequestMapping(value = "transfer", method= RequestMethod.POST)
//	public String transfer (TransferDTO transferdto) throws Exception {
//		// tranasferdto : 계좌번호가 1개
//		// 보내는 계좌 : account_number
//		// 받는 계좌 : receive_number
//		
//		int result = transferService.trade(transferdto);
//		return "redirect:../member/mypage";
//	}

	@RequestMapping(value = "transfer", method= RequestMethod.POST)
	public void transfer(AccountDTO accountDTO  ,HttpSession session, HttpServletRequest request) throws Exception {
		
//		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//		memberDTO = memberService.detail(memberDTO);
		
		accountDTO = accountService.detail(accountDTO);
		System.out.println(accountDTO.getAccount_number());
		
		String user = request.getParameter("balance");
		System.out.println("=================");
		System.out.println(request.getParameter("my_account_number"));
	
		//계좌가 있는지 파악
		//상대 계좌
		if(accountDTO.getAccount_number().equals(request.getParameter("account_number"))){
//			accountDTO.setBalance((Integer)user);
//			
//			accountService.update(accountDTO);
		}
	}

	
		
}
