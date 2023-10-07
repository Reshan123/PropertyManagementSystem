package com.PropertyManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Validate {

	static String url = "jdbc:mysql://localhost:3306/propertymanagementsystem";
	static String DBusername = "root";
	static String DBpassword = "";
	
public static User login(String email , String password) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
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
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;		
		
	}

	public static User signin(String username , String password , String email) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "INSERT INTO users(userName , email , userPassword) VALUES ('" + username + "','" + email + "','" + password + "')";
			
			statementObj.execute(sql);
			
			User user = login(email , password);
			return user;
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;
		
	}
	
	public static User update(int UID ,String username , String password , String email) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "UPDATE users SET userName = '" + username + "', userPassword = '" + password + "' , email = '" + email +"' WHERE (UID = " + UID + ")";
			
			statementObj.execute(sql);
			
			User user = login(email , password);
			return user;
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}	
		
		return null;
	}
}




