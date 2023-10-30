package com.UserServlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;


public class FeedbackEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get all the inputs from the feedback jsp
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String Email = request.getParameter("Email");
		String message = request.getParameter("message");
		Integer UID = Integer.parseInt(request.getParameter("UID"));
		
		//get connection and the sql statement for executing
		Statement statementObj = GetConnection.getConnection();
		String sql = "UPDATE feedbackreg SET Fname='"+firstName+"' , Lname='"+lastName+"' , Email='"+Email+"' , Message='"+message+"' WHERE UID="+UID;
		
		//execute the sql statement
		try {
			statementObj.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//redirect to getfeedback servlet
		response.sendRedirect("GetFeedback");
		
	}

}
