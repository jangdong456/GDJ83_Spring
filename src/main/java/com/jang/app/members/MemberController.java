package com.jang.app.members;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("join")
	public void join(Model model) {
		System.out.println("controller");
	
//		model.addAttribute("join");
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join2(MemberDTO memberDTO) throws Exception {
		System.out.println("join@@@@@@@@");
		int result = memberService.join(memberDTO);
		
		String url ="";
		
		if(result > 0) {
			url = "redirect:/";
		}else {
			
		}
		return url;
	}
	
	@RequestMapping("login")
	public void login(Model model, @CookieValue(name = "remember", required = false) String value) {
		model.addAttribute("id", value);
//		Cookie[] cookies = request.getCookies();
//		for(Cookie c : cookies) {
//			if(c.getName().equals("remember")) {
//				request.setAttribute("id", c.getValue());
//			}
//		}
		System.out.println("login");
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO, String remember, HttpServletResponse response, HttpSession session) throws Exception {

		memberDTO = memberService.login(memberDTO);

		if(memberDTO != null) {
			session.setAttribute("member",memberDTO);
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
		System.out.println("id기억 : " + remember);
		
		if(remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getMember_name());
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		return "redirect:/";
	}
	

	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
	// logout의 기능은 세션을 없애려고 만든다.
		// invalidate() : session의 유지시간을 0으로 만들겠다. 의미
		session.invalidate();
		return "redirect:/";
	}
	
	
}
