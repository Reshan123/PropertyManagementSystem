package com.Servlets;

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
			
			statementObj = GetConnection.getConnection();
			String sql = "SELECT * FROM contact";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
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
		
		HttpSession session = request.getSession();
		session.setAttribute("contact", contact);
		response.sendRedirect("contact.jsp");
		
	}

}
