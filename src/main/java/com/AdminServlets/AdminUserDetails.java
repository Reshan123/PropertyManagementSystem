package com.AdminServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;
import com.PropertyManagementSystem.User;

public class AdminUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	static String url = "jdbc:mysql://localhost:3306/propertymanagementsystem";
	static String DBusername = "root";
	static String DBpassword = "";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> UserList = new ArrayList<User>();
		Statement statementObj = null;
		
		try {
			
			statementObj = GetConnection.getConnection();
			String sql = "SELECT * FROM users";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			while(resultSetObj.next()) {
				
				int UID = resultSetObj.getInt(1);
				String Username = resultSetObj.getString(2);
				String Email = resultSetObj.getString(3);
				String Password = resultSetObj.getString(4);
				
				User user = new User(UID,Username,Email,Password);
				UserList.add(user);
			}
			
			
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		request.setAttribute("UserList", UserList);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("adminUser.jsp");
		reqDis.forward(request, response);
		
	}
}
