package com.jang.app.boards.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.jang.app.boards.BoardDTO;
import com.jang.app.members.MemberDTO;
import com.jang.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		// 리턴하는 값이 value가 된다.
		return "Notice";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model,Pager pager) throws Exception {
		System.out.println("===== List Controller ====");
//		MemberDTO mId = (MemberDTO)session.getAttribute("member");
//		noticedto.setM_id(mId.getM_id());

		List<BoardDTO> list = noticeService.list(pager);
		
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(HttpSession session, NoticeDTO noticedto) throws Exception {
		System.out.println("===== Add Controller ====");
		return "board/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2(HttpSession session, NoticeDTO noticedto, MultipartFile [] files) throws Exception {
		System.out.println("===== Add2 Controller ====");
		MemberDTO mId = (MemberDTO)session.getAttribute("member");		
		noticedto.setBoard_writer(mId.getM_id());
		System.out.println("@@@@@@@@@@@@@@@@@@@");
		System.out.println(files);
		String url = "commons/message";
		
		int result = noticeService.add(noticedto, files, session);
		
		if(result>0) {
			url = "redirect:./list";
			return url;
		}
		return url;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(NoticeDTO noticeDTO, Model model) throws Exception {
		System.out.println("===== detail Controller =====");
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		
		String url = "board/detail";
		if(boardDTO != null) {
			System.out.println("값 들어옴");
			System.out.println(boardDTO.getBoard_contents());
			model.addAttribute("dto", boardDTO);
			return url;
			
		} else {
			System.out.println("값 안들어옴@@@@@@@@@");
		}
		return url;
	}
	
	@GetMapping("update")
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		System.out.println("===== update Controller =====");
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		
		String url = "board/add";
		
		if(boardDTO != null) {
			System.out.println("값 들어옴");
			model.addAttribute("dto", boardDTO);
			System.out.println(boardDTO.getBoard_contents());
			return url;
		} else {
			System.out.println("값 안들어옴@@@@@@@@@");
		}	
		return url;
	}
	
	@PostMapping("update")
	public String update(NoticeDTO noticeDTO) throws Exception {
		System.out.println("===== update2 Controller =====");
		int result = noticeService.update(noticeDTO);
		
		String url = "redirect:/board/list";
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
		
		String url = "redirect:/board/list";
		
		if(result > 0) {
			System.out.println("delete success");
			return url;
		}
		return url;
	}
	
}
