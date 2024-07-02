package com.jang.app.proudct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.app.util.DBConnection;


@Repository
public class ProductDAO {
	
	@Autowired
	private DBConnection dbconnetion;
	
	public List<ProductDTO> getList() throws Exception {
		System.out.println("dao"); 
		Connection con =  dbconnetion.getConnection();
			
		String sql = "SELECT * FROM PRODUCT";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			
			dto.setProduct_id(rs.getInt("product_id"));
			dto.setProduct_type(rs.getString("product_type"));
			dto.setProduct_rate(rs.getDouble("product_rate"));
			dto.setProduct_detail(rs.getString("product_detail"));

			ar.add(dto);
		}
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	public ProductDTO detail(int product_id) throws Exception {
		System.out.println("dao");
		
		 Connection con = dbconnetion.getConnection();
		 
		 String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
		
		 PreparedStatement st = con.prepareStatement(sql);
		 
		 st.setInt(1, product_id);
		 
		 ResultSet rs = st.executeQuery();
		 
		 ProductDTO dto = null;
		 
		 if(rs.next()) {
			 dto = new ProductDTO();
			 
			 dto.setProduct_id(rs.getInt("product_id"));
			 dto.setProduct_type(rs.getString("product_type"));
			 dto.setProduct_rate(rs.getDouble("product_rate"));
			 dto.setProduct_detail(rs.getString("product_detail"));
		 }
		 rs.close();
		 st.close();
		 con.close();
		 
		 return dto;
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		Connection con = dbconnetion.getConnection();
		
		String sql = "INSERT INTO PRODUCT"
				+ " (PRODUCT_ID, PRODUCT_TYPE, PRODUCT_RATE, PRODUCT_DETAIL"
				+ " VALUES(BANK_SEQ.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, productDTO.getProduct_type());
		st.setDouble(2, productDTO.getProduct_rate());
		st.setString(3, productDTO.getProduct_detail());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		Connection con = dbconnetion.getConnection();
		
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, productDTO.getProduct_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
}
