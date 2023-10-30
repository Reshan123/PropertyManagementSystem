package com.UserServlets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.PropertyManagementSystem.GetConnection;
import com.PropertyManagementSystem.User;

public class Validate {
	
	// Login user method
	public static User login(String email , String password) {
	
		// get connection for database and execting and making user object
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
				//return the object
				return user;
			}
			
			
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;		
		
	}
	
	// Sigin user method
	public static User signin(String username , String password , String email) {
		//getting database connection and execting the insert sql  
		try {
			
			Statement statementObj = GetConnection.getConnection();
			String sql = "INSERT INTO users(userName , email , userPassword) VALUES ('" + username + "','" + email + "','" + password + "')";
			
			statementObj.execute(sql);
			
			User user = login(email , password);
			//return user object
			return user;
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;
		
	}
	
	//  user update method
	public static User update(int UID ,String username , String password , String email) {
		
		// get database connection and execting update 
		try {
			
			Statement statementObj = GetConnection.getConnection();
			String sql = "UPDATE users SET userName = '" + username + "', userPassword = '" + password + "' , email = '" + email +"' WHERE (UID = " + UID + ")";
			
			statementObj.execute(sql);
			
			User user = login(email , password);
			//return user object
			return user;
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}	
		
		return null;
	}
	
	//get user object from the ID
	public static User getUserFromID(int UID) {
		
		//database connection and selecting user details from the UID
		try {
			
			Statement statementObj = GetConnection.getConnection();
			String sql = "SELECT * FROM users WHERE UID = " + UID;
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			if(resultSetObj.next()) {
				int uid = resultSetObj.getInt(1);
				String uname = resultSetObj.getString(2);
				String uemail = resultSetObj.getString(3);
				String upass = resultSetObj.getString(4);
				
				//create user object and return it
				User user = new User(uid,uname,uemail,upass);
				return user;
			}
			
			
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;		
		
	}
}




