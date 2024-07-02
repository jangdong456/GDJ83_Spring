package com.jang.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBconnetion {
	
	public Connection getConnertion() throws Exception {
		String username = "user01";
		String password = "user01";
		
		String url = "jdbc:oracle:thin:@43.201.16.30:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		return con;
	}
}
