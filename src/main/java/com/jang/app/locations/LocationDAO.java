package com.jang.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.app.util.DBConnection;

@Repository
public class LocationDAO {
	
	@Autowired
	private DBConnection dbConnection;
	
	public List<LocationDTO> getList() throws Exception {
//		Connection 디비연결 >  PreparedStatement 작성한 쿼리문 전송 > ResultSet 최종전송 및 결과처리
		
		System.out.println("DAO");
		
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		//담아야함
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		while(rs.next()) {
			
			LocationDTO dto = new LocationDTO();
			
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
			
			ar.add(dto);
		}
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	public LocationDTO getDetail(int location_id) throws Exception {
		System.out.println("디에이오");
		
		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		// 나중에 매개변수 셋팅해줘야함
		st.setInt(1, location_id);
		
		ResultSet rs = st.executeQuery();
		
		LocationDTO dto = null;
		
		if(rs.next()) {
			dto = new LocationDTO();
			dto.setCity(rs.getString("CITY"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			
		}
		rs.close();
		st.close();
		con.close();
		
		return dto;
	}
	
	public int add(LocationDTO locationDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		
		String sql = "INSERT INTO LOCATIONS "
					 + "(LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY)"
					 + " VALUES(LOCATIONS_SEQ.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		
		int resutl = st.executeUpdate(); 
		
		st.close();
		con.close();
		
		return resutl;
		
	}
	
}
