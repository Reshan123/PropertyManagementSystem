package com.UserServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.GetConnection;

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UserCount = "";
		String PropertyCount = "";
		Statement statementObj = null;
		
		try {
			statementObj = GetConnection.getConnection();
			String sqlUserCount = "SELECT COUNT(*) FROM users";
			
			ResultSet resultSetObjUserCount = statementObj.executeQuery(sqlUserCount);
			
			while(resultSetObjUserCount.next()) {
				
				UserCount = resultSetObjUserCount.getString(1);			
			}
			
			
			String sqlPropertyCount = "SELECT COUNT(*) FROM property";
			
			ResultSet resultSetObjPropertyCount = statementObj.executeQuery(sqlPropertyCount);
			
			while(resultSetObjPropertyCount.next()) {
				
				PropertyCount = resultSetObjPropertyCount.getString(1);			
			}
			
		}catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}

		HttpSession session = request.getSession();
		session.setAttribute("UserCount", UserCount);
		session.setAttribute("PropertyCount", PropertyCount);
		response.sendRedirect("index.jsp");
		
		
	}

}
