package com.jang.app.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jang.app.members.MemberDTO;
import com.jang.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model,Pager pager) throws Exception {
		System.out.println("===== List Controller ====");
//		MemberDTO mId = (MemberDTO)session.getAttribute("member");
//		noticedto.setM_id(mId.getM_id());

		List<NoticeDTO> list = noticeService.list(pager);
	
		model.addAttribute("pager", pager);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(HttpSession session, NoticeDTO noticedto) throws Exception {
		System.out.println("===== Add Controller ====");	
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2(HttpSession session, NoticeDTO noticedto) throws Exception {
		System.out.println("===== Add2 Controller ====");
		MemberDTO mId = (MemberDTO)session.getAttribute("member");
		
		noticedto.setBoard_writer(mId.getM_id());
		
		String url = "commons/message";
		int result = noticeService.add(noticedto);
		
		if(result>0) {
			url = "redirect:/notice/list";
			return url;
		}
		return url;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(NoticeDTO noticeDTO, Model model) throws Exception {
		System.out.println("===== detail Controller =====");
		noticeDTO = noticeService.detail(noticeDTO);
		
		if(noticeDTO != null) {
			System.out.println("값 들어옴");
			model.addAttribute("dto", noticeDTO);
			
			System.out.println(noticeDTO.getBoard_contents());
		} else {
			System.out.println("값 안들어옴@@@@@@@@@");
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model) throws Exception {
		System.out.println("===== update Controller =====");
		noticeDTO = noticeService.detail(noticeDTO);
		
		if(noticeDTO != null) {
			System.out.println("값 들어옴");
			model.addAttribute("dto", noticeDTO);
			
			System.out.println(noticeDTO.getBoard_contents());
		} else {
			System.out.println("값 안들어옴@@@@@@@@@");
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update2(NoticeDTO noticeDTO) throws Exception {
		System.out.println("===== update2 Controller =====");
		int result = noticeService.update(noticeDTO);
		
		String url = "redirect:/notice/list";
		if(result > 0) {
			System.out.println("update success");
			return url;
		}
		return url;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String detele(NoticeDTO noticeDTO) throws Exception {
		System.out.println("===== delete Controller =====");
		int result = noticeService.delete(noticeDTO);
		
		String url = "redirect:/notice/list";
		
		if(result > 0) {
			System.out.println("delete success");
			return url;
		}
		return url;
	}
	
}
