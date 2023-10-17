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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.*;

public class AdminFeedbackReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static String url = "jdbc:mysql://localhost:3306/propertymanagementsystem";
	static String DBusername = "root";
	static String DBpassword = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<FeedbackDetails> feedbackList = new ArrayList<FeedbackDetails>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "SELECT * FROM feedbackreg";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			while(resultSetObj.next()) {
				
				String Fname = resultSetObj.getString(2);
				String Lname = resultSetObj.getString(3);
				String Email = resultSetObj.getString(4);
				String Message = resultSetObj.getString(5);
				
				FeedbackDetails feedbackObj = new FeedbackDetails(Fname,Lname,Email,Message);
				feedbackList.add(feedbackObj);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		request.setAttribute("FeedbackList", feedbackList);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("adminFeedbackReg.jsp");
		reqDis.forward(request, response);
		
	}

}
