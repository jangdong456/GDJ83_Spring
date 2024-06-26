package com.jang.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {
	
	@Autowired
	private EmployeesDAO employeesDAO;
	
	public List<EmployeesDTO> getList() throws Exception {
		List<EmployeesDTO> ar = employeesDAO.getList();
		
		return ar;
	}
}
