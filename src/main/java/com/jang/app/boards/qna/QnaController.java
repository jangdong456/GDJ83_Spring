package com.jang.app.boards.qna;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@GetMapping("list")
	public ModelAndView list(ModelAndView mv) throws Exception {
		
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("detail")
	public String detail(Model model) throws Exception {
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}
 	
	@GetMapping("update")
	public String update() throws Exception {
		return "board/update";
	}
	
}
