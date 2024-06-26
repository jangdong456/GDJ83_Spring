package com.jang.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employees/*")
public class EmployeesController {
	
	@Autowired
	private EmployeesService employeesService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("controller");
		 List<EmployeesDTO> ar = employeesService.getList();
		 
		 model.addAttribute("list", ar);
	}
}
