package com.UserServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.ContactDetails;
import com.PropertyManagementSystem.GetConnection;

public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactDetails contact = null;
		Statement statementObj = null;
		
		try {
			// get connection
			statementObj = GetConnection.getConnection();
			String sql = "SELECT * FROM contact";
			//run sql command
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			// get the results and add to contact objext
			if(resultSetObj.next()) {
				int ContactID = resultSetObj.getInt(1);
				String Description = resultSetObj.getString(2);
				String Phone = resultSetObj.getString(3);
				String Email = resultSetObj.getString(4);
				String Address = resultSetObj.getString(5);
				
				contact = new ContactDetails(ContactID,Description,Phone,Email,Address);
			}
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		// get session from from request
		HttpSession session = request.getSession();
		//setting contact object session
		session.setAttribute("contact", contact);
		//redirect to contact.jsp page
		response.sendRedirect("contact.jsp");
		
	}

}
