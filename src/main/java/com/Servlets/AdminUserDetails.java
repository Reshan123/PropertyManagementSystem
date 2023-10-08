package com.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.User;

@WebServlet("/Admin/AdminUserDetails")
public class AdminUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	static String url = "jdbc:mysql://localhost:3306/propertymanagementsystem";
	static String DBusername = "root";
	static String DBpassword = "";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> UserList = new ArrayList<User>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
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
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		request.setAttribute("UserList", UserList);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("adminUser.jsp");
		reqDis.forward(request, response);
		
	}
}
