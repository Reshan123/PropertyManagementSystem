package com.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static String url = "jdbc:mysql://localhost:3306/propertymanagementsystem";
	static String DBusername = "root";
	static String DBpassword = "";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UserCount = "";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "SELECT COUNT(*) FROM users";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			while(resultSetObj.next()) {
				
				UserCount = resultSetObj.getString(1);			
			}
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}

		HttpSession session = request.getSession();
		session.setAttribute("UserCount", UserCount);
		
		response.sendRedirect("index.jsp");
		
		
	}

}
