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
	//Model model 에서 여기서 model 매개변수는 알아서 spring이 만들어서 던저줌
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
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	// spring이 매개변수 파라미터 받을 때 내가 원하고자 하는 타입을 명시만 해주면 알아서 string 타입에서 명시한 타입으로 바꿔줌
	// @RequestParam(name="num") | 만약에 프론트에서 파라미터명을 일치하지 않을 시에 @RequestParm 을 사용해서 속성값을 준다. | 하지만 두개다 인식(num or department_id)하는게 아니라 잘 사용안함
	// 안넘길때 defaultValue 값을 줄때도 있다. -> 에러발생이 디폴트를 사용해서 에러를 안뜨게함
	public String getDetail(Model model, int department_id) throws Exception {
		System.out.println("디테일");
		
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		
		String path ="commons/message";
		
		if(departmentDTO != null) {			
			model.addAttribute("detail", departmentDTO);
			path = "department/detail";
		} else {
			model.addAttribute("result", "부서를 찾을 수가 없다");
			model.addAttribute("url", "./list");
		} return path; 
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	// 파라미터를 DTO에 담는 방법 : 매개변수 3개 받을걸 옆에서처럼 한번에 받을수 있음-> DepartmentDTO departmentDTO 사용하려면 조건이 필요함
	// 조건 : 파라미터 이름과 setter의 이름이 같아야함 
	// 그러면 DTO 안에 있는 변수 값을 찾아서 알아서 setter로 인해 값이 들어감
	public String add2(DepartmentDTO departmentDTO, Model model) throws Exception {
		
		int result = departmentService.add(departmentDTO);
		
		String url = "";
		
		if(result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("resutl", "부서 등록 실패");
			model.addAttribute("url", "./list");
		}
		return url;
	}
	
	@RequestMapping("delete")
	public String delete(DepartmentDTO departmentDTO, Model model) throws Exception {
		System.out.println("삭제");
		int result = departmentService .delete(departmentDTO);
		
		String url = "commons/message";
		if (result > 0 ) {
			url = "redirect:./list";
		} else {
			model.addAttribute("resutl", "삭제 실패");
			model.addAttribute("url", "list");
		}
		return url;
	}
	
	@RequestMapping("update")
	public String update(int department_id, Model model) throws Exception {
		System.out.println("업데이트");
		DepartmentDTO dto = departmentService.getDetail(department_id);
			
		String url = "commons/message";
		
		if(dto != null) {
			model.addAttribute("dto", dto);
			url = "department/update";
		} else {
			model.addAttribute("result", "없는 부서");
			model.addAttribute("url", "list");
		}
		return url;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(DepartmentDTO departmentdto) throws Exception {
		int result = departmentService.update(departmentdto);
		
		return "redirect:list";
	}
}


