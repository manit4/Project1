package com.hcl.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	static public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini1", "root", "root");
			
		}
		catch(Exception e) {
			
			System.out.println("inside catch of getConnection...");
			e.printStackTrace();
		}
		
		return conn;

	}

}
