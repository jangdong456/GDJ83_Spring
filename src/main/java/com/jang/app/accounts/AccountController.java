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
import com.jang.app.transfers.TransferDTO;


@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
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
	public void transfer() throws Exception {

	}

	@RequestMapping(value = "transfer", method= RequestMethod.POST)
	public void transfer2(AccountDTO accountDTO ,TransferDTO transferdto ,HttpSession session, HttpServletRequest request) throws Exception {
//		MemberDTO accountdto = (MemberDTO)session.getAttribute("member");
//		System.out.println("확인 : "+ accountdto.getMember_number());
//		System.out.println("======= : " + accountDTO.getAccount_number());
//		
//		System.out.println(request.getParameter("account_number"));
//		System.out.println(request.getParameter("amount"));
		
		AccountDTO result = accountService.transfer(accountDTO);
		System.out.println(accountDTO.getAccount_number());
		System.out.println(accountDTO.getBalance());
		
		
		if(accountDTO.getAccount_number().equals(result.getAccount_number())) {
			System.out.println("==============");
			accountService.update(accountDTO);
			System.out.println("통과");
			
		}
		
	}
		
}
