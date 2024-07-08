package com.jang.app.accounts;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jang.app.members.MemberDTO;


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
}
