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
		
		//1.디비 연결(접속)
		Connection con = dbConnection.getConnection();
		System.out.println(con);
		
		//2. SQL(Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";
		
		//3. PreparedStatement : 작성한 쿼리문을 미리 전송하는 거 -> 미리 서버로 보내서 준비를 하라는 뜻
		// 왜 미리 보낼까 ?  나중에 pw값 매개변수로 받을때 쿼리문 pw값을 ? 물음표로 보내야하기 때문에
		// 그 이후 4번에서 셋팅한다.
		PreparedStatement st = con.prepareStatement(sql);
		
		//4.  셋팅 | 나중에 ? 물음표 값이 생기는데 이건 나중에
		
		//5. ResultSet 타입의 executeQuery() : 최종전송 및 결과 처리 단계
		// 작성한 쿼리문은 ResultSet 에 담긴다.
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
	
	public DepartmentDTO getDetail(int num) throws Exception {
		
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?"; 
		
		PreparedStatement st = con.prepareStatement(sql);
		
		//4.셋팅 sql변수 ? 표 인덱스 번호 , 매개변수 num 을 넣어준다.
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO dto = null;
		
		if(rs.next()) {
			dto = new DepartmentDTO();
			
			dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			dto.setDepartment_name(rs.getNString("DEPARTMENT_NAME"));
			dto.setManager_id(rs.getLong("MANAGER_ID"));
		}
		rs.close();
		st.close();
		con.close();
		
		return dto;
	}
	
	//매개변수로 DTO에 값을 넣어주기위해서 불러옴
	public int add(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		
		String sql = "INSERT INTO DEPARTMENTS"
				+ " (DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID)"
				+ " VALUES(DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		// ?표값 셋팅
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		
		// 값만 집어 넣을때 사용 executeUpdate()
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int update(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? "
					+ " WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}
