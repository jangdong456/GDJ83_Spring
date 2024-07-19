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
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value ="join", method = RequestMethod.GET)
	public void join(Model model) {
		System.out.println("controller");
		
	
//		model.addAttribute("join");
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join2(HttpSession session ,MemberDTO memberDTO, MultipartFile files) throws Exception {
		System.out.println(session.getServletContext());

		int result = memberService.join(memberDTO, files, session);
		
		String url ="redirect:/";
		
//		if(result > 0) {
//			url = "redirect:/";
//		}else {
//			
//		}
		return url;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
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
		
//		memberDTO = memberService.login(memberDTO);

		
		
		MemberDTO result = memberService.login(memberDTO);
				
		if(memberDTO != null) {
			session.setAttribute("member",result);

			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
		
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
		// 세션 유지시간 0으로 만드는 방법들
		session.invalidate(); // invalidate() : session의 유지시간을 0으로 만들겠다 라는 의미
//		session.setAttribute("member", null);// 속성 값을 null로 바꿈
//		session.removeAttribute("member"); // 속성과 벨류 없앰
		return "redirect:/";
	}
	
	@RequestMapping(value ="mypage", method = RequestMethod.GET)
	public void mypage(HttpSession session, Model model) throws Exception {
		System.out.println("들어옴?");
		MemberDTO memberdto = (MemberDTO)session.getAttribute("member");

		memberdto = memberService.detail(memberdto);
		model.addAttribute("member", memberdto);

	}


	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(HttpSession session, Model model) throws Exception {
		MemberDTO memberdto = (MemberDTO)session.getAttribute("member");
		
		memberdto = memberService.detail(memberdto);
		model.addAttribute("member", memberdto);

	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberdto, HttpSession session) throws Exception {
		
		MemberDTO user = (MemberDTO)session.getAttribute("member");
//		memberdto.setMember_id(user.getMember_id());
		
		memberdto.setM_id(user.getM_id());
		
		int result = memberService.update(memberdto);
		
		if(result >0) {
			session.setAttribute("member", memberdto);
		}
		
		return "redirect:../";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpSession session, MemberDTO memberdto) throws Exception {
		
		MemberDTO user = (MemberDTO)session.getAttribute("member");
		
		System.out.println();
		
		int result = memberService.delete(user);
		
		if( result > 0) {
			session.invalidate();	
		}
	
		return "redirect:../";
	}
}
