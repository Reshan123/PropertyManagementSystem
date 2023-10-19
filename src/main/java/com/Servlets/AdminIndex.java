package com.Servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;


public class AdminIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UserCount = "";
		Statement statementObj = null;
		
		try {
			
			statementObj = GetConnection.getConnection();
			String sql = "SELECT COUNT(*) FROM users";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			while(resultSetObj.next()) {
				
				UserCount = resultSetObj.getString(1);			
			}
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		request.setAttribute("UserCount", UserCount);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("adminIndex.jsp");
		reqDis.forward(request, response);
		
		
	}

}
