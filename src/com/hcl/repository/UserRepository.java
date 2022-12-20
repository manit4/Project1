package com.hcl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.db.DBConnection;
import com.hcl.to.UserTO;

public class UserRepository {
	
	public void saveUser(UserTO to) {
		
		Connection conn = DBConnection.getConnection();
		
		try {
			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?)");
			
			statement.setString(1, to.getUsername());
			statement.setString(2, to.getPassword());
			statement.setString(3, to.getName());
			statement.setString(4, to.getEmail());
			statement.setString(5, to.getRole());
			
			statement.executeUpdate();
			
		} 
		catch (SQLException e) {
			System.out.println("inside catch of saveUser()");
			e.printStackTrace();
		}	
	}
	
	public UserTO getUser(String username, String password) {
		
		UserTO to = null;
		
		try {
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement statement = conn.prepareStatement("select * from user where username = ? and password = ?");
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				
				String uname = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String role = rs.getString(5);
				
				to = new UserTO(uname, pwd, name, email, role);
			}
			
		}
		catch(Exception e) {
			System.out.println("inside catch of getUser()");
			e.printStackTrace();
		}
		
		return to;

	}

}
