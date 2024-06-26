package com.jang.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.app.util.DBConnection;

@Repository
public class EmployeesDAO {
	
	@Autowired
	private DBConnection dbConnection;
	
	public List<EmployeesDTO> getList() throws Exception {
		System.out.println("dao");
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();
		
		while(rs.next()) {
			EmployeesDTO dto = new EmployeesDTO();
			
			dto.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			dto.setFirst_name(rs.getString("FIRST_NAME"));
			dto.setLast_name(rs.getString("LAST_NAME"));
			dto.setJob_id(rs.getString("JOB_ID"));
//			dto.setEmail(rs.getString("EMAIL"));
//			dto.setPhone_number(rs.getInt("PHONE_NUMBER"));
//			dto.setHire_date(rs.getString("HIRE_DATE"));
//			dto.setSalary(rs.getInt("SALARY"));
//			dto.setCommission_pct(rs.getInt("COMMISSION_PCT"));
//			dto.setManager_id(rs.getInt("MANAGER_ID"));
//			dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			
			ar.add(dto);
		}
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
}
