package com.jang.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*")
// @RequestMapping("/department/*") -> department로 오는 모든것들은 여기로 와라 뜻
public class DepartmentController {

	// IOC : 제어의 역전 | 개발자가 하는게 아니라 스프링프레임워크한테 이렇게 해주세요 => 어노테이션
	// 객체생성 | 메서드호출
	// 객체생성 -> 어노테이션 : 1.controller 2.service 3.repository 4.component(1,2,3번이 아닌 그외를 만들고 싶을대 사용)
	@Autowired
	private DepartmentService departmentService;
	
	// 위에 @RequestMapping("/department/*") 가있이기에 밑에 value는 list만 써준다.
	// 
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {	
		System.out.println("department list");
		List<DepartmentDTO> ar = departmentService.getList();
		
		// 모데을 사용하는 방식 2가지가 있음
		// 1. ModelAndView() 객체만들기
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("list", ar);
		
//		return mv;
		//2.  매개변수로 받아서 리턴 model.addAttribute("list",ar);
		model.addAttribute("list",ar);
	}
}


