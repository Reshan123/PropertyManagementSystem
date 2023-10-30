package com.UserServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.FeedbackDetails;
import com.PropertyManagementSystem.GetConnection;
import com.PropertyManagementSystem.User;

public class GetFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get session object from request object in the servlet
		HttpSession session = request.getSession();
		
		//get user session from sessions
		User user = (User) session.getAttribute("user");
		Statement statementObj = null;
		
		//create feedback details object
		FeedbackDetails feedback = null;
		
		//execute the sql statement 
		try {
			statementObj = GetConnection.getConnection();
			String sql = "SELECT * FROM feedbackreg WHERE UID =" + user.getUID();
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			if(resultSetObj.next()) {
				String Fname = resultSetObj.getString(2);
				String Lname = resultSetObj.getString(3);
				String Email = resultSetObj.getString(4);
				String Message = resultSetObj.getString(5);
				int UID = resultSetObj.getInt(6);
				
				feedback = new FeedbackDetails(Fname,Lname,Email,Message,UID);
				
			}
			
		} catch(Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		//set feedback object to the request object of the servlet
		request.setAttribute("feedback", feedback);
		
		//redirect to feedback jsp
		RequestDispatcher reqDis = request.getRequestDispatcher("feedback.jsp");
		//redirect with the request and response objects of the current servlet
		reqDis.forward(request, response);
		
	}

}
