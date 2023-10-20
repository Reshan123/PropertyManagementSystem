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
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Statement statementObj = null;
		
		FeedbackDetails feedback = new FeedbackDetails("","","","",user.getUID());
		
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
		
		request.setAttribute("feedback", feedback);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("contact.jsp");
		reqDis.forward(request, response);
		
	}

}
