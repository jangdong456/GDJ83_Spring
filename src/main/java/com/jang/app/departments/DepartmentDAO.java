package com.jang.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.app.util.DBConnection;

@Repository
public class DepartmentDAO {
	
	//DI, IOC
	
	@Autowired
	private DBConnection dbConnection;
	
	public List<DepartmentDTO> getList() throws Exception {
		
		//디비 연결
		Connection con = dbConnection.getConnection();
		System.out.println(con);
		
		// SQL(Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";
		
		// PreparedStatement : 작성한 쿼리문을 미리 전송하는 거 -> 미리 서버로 보내서 준비를 하라는 뜻
		PreparedStatement st = con.prepareStatement(sql);
		
		// 나중에 ? 물음표 값이 생기는데 이건 나중에
		
		// ResultSet 타입의 executeQuery() : 최종전송 및 결과 처리 단계
		ResultSet rs = st.executeQuery();
		
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		
		// ResultSet 타입의 next()메서드 : 한줄 읽으라는 메서드 boolean값 리턴
		while(rs.next()) {
			
			DepartmentDTO departmentDTO = new DepartmentDTO();
			
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			
			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			
			ar.add(departmentDTO);
		}
		
		// 디비랑 자원 해체 -> 연결된 순서 역순으로 해제하기
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
}
