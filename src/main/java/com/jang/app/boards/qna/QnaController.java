package com.jang.app.boards.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jang.app.boards.BoardDTO;
import com.jang.app.members.MemberDTO;
import com.jang.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	private int main;
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		// 리턴하는 값이 value가 된다.
		return "QnA";
	}
	
	@GetMapping("list")
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		
		List<BoardDTO> ar = qnaService.list(pager);
		mv.addObject("list",ar);
		
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("detail")
	public String detail(Model model, QnaDTO qnaDTO) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(QnaDTO qnaDTO, HttpSession session) throws Exception {
		MemberDTO memberDTO  = (MemberDTO)session.getAttribute("member");
		qnaDTO.setBoard_writer(memberDTO.getM_id());
		int result = qnaService.add(qnaDTO);
		return "redirect:./list";
	}
 	
	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		
		return "board/add";
	}
	
	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {
		
		int result = qnaService.update(qnaDTO);
		
		return "redirect:./list";
	}
		
	@GetMapping("delete")
	public String delete(QnaDTO qnaDTO) throws Exception {
		 int result = qnaService.delete(qnaDTO);
		 
		 return "redirect:./list";
	}
	
	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("boardDTO", qnaDTO);
		return "board/add";
	}
	
	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, HttpSession session) throws Exception {
		MemberDTO memberDTO  = (MemberDTO)session.getAttribute("member");
		qnaDTO.setBoard_writer(memberDTO.getM_id());
		int result = qnaService.reply(qnaDTO);
		
		return "redirect:./list";
	}

}
