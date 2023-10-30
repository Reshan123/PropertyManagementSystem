package com.UserServlets;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;


public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get all the inputs from the feedback jsp
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String Email = request.getParameter("Email");
		String message = request.getParameter("message");
		Integer UID = null;
		
		//get UID if it is set
		if (request.getParameter("UID") != null) {
			UID = Integer.parseInt(request.getParameter("UID"));
		}
		
		Statement statementObj = null;
		//get connection and execute the required the sql if the user id is set
		try {
			
			statementObj = GetConnection.getConnection();
			if (UID == null) {
				String sql = "INSERT INTO feedbackunreg (Fname , Lname , Email , Message ) VALUES ('"+firstName+"','"+lastName+"','"+Email+"', \" "+message+" \" )";
				statementObj.execute(sql);
			} else {
				String sql = "INSERT INTO feedbackreg (Fname , Lname , Email , Message , UID ) VALUES ('"+firstName+"','"+lastName+"','"+Email+"', \" "+message+" \" , "+ UID +" )";
				statementObj.execute(sql);
			}
			
			
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		//redirect to feedback jsp
		response.sendRedirect("GetFeedback");
		
	}

}
