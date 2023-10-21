package com.UserServlets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.PropertyManagementSystem.GetConnection;
import com.PropertyManagementSystem.User;

public class Validate {
	
	public static User login(String email , String password) {
	
		try {
			
			Statement statementObj = GetConnection.getConnection();
			String sql = "SELECT * FROM users WHERE email = '" + email + "' AND userPassword = '" + password + "'";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			if(resultSetObj.next()) {
				int uid = resultSetObj.getInt(1);
				String uname = resultSetObj.getString(2);
				String uemail = resultSetObj.getString(3);
				String upass = resultSetObj.getString(4);
				
				User user = new User(uid,uname,uemail,upass);
				return user;
			}
			
			
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;		
		
	}

	public static User signin(String username , String password , String email) {
		
		try {
			
			Statement statementObj = GetConnection.getConnection();
			String sql = "INSERT INTO users(userName , email , userPassword) VALUES ('" + username + "','" + email + "','" + password + "')";
			
			statementObj.execute(sql);
			
			User user = login(email , password);
			return user;
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;
		
	}
	
	public static User update(int UID ,String username , String password , String email) {
		
		try {
			
			Statement statementObj = GetConnection.getConnection();
			String sql = "UPDATE users SET userName = '" + username + "', userPassword = '" + password + "' , email = '" + email +"' WHERE (UID = " + UID + ")";
			
			statementObj.execute(sql);
			
			User user = login(email , password);
			return user;
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}	
		
		return null;
	}
	
	public static String getUserName(int UID) {
		
		try {
			
			Statement statementObj = GetConnection.getConnection();
			String sql = "SELECT * FROM users WHERE UID = " + UID;
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			if(resultSetObj.next()) {
				String uname = resultSetObj.getString(2);
				return uname;
			}
			
			
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;		
		
	}
}




