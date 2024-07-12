package com.jang.app.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jang.app.members.MemberDTO;
import com.jang.app.members.MemberService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model, HttpSession session, NoticeDTO noticedto) throws Exception {
		System.out.println("===== List Controller ====");
		MemberDTO mId = (MemberDTO)session.getAttribute("member");
		noticedto.setM_id(mId.getM_id());
		
		List<NoticeDTO> ar = noticeService.list(noticedto);
		
		
		model.addAttribute("list",ar);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(HttpSession session, NoticeDTO noticedto) throws Exception {
		System.out.println("===== Add Controller ====");
		
		MemberDTO mId = (MemberDTO)session.getAttribute("member");
		noticedto.setM_id(mId.getM_id());
		noticeService.add(noticedto);

	}
}
