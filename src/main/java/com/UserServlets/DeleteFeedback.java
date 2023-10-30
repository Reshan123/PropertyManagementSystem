package com.UserServlets;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;


public class DeleteFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get user if from the feedback page
		int UID = Integer.parseInt(request.getParameter("UserID"));
		Statement statementObj = null;
		//get connection and execute the sql
		try {
			
			statementObj = GetConnection.getConnection();
			String sql = "DELETE FROM feedbackreg WHERE UID = " + UID;
			
			statementObj.execute(sql);			
			
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		//redirect to contact page
		response.sendRedirect("contact.jsp");
		
	}

}
