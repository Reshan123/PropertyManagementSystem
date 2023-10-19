package com.Servlets;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;


public class UpdateContactDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String description = request.getParameter("description");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Statement statementObj = null;
		
		try {
			statementObj = GetConnection.getConnection();
			String sql = "UPDATE contact set description = '" + description + "', phone = '" + phone + "', email = '" + email + "' , address = '" + address + "' WHERE ID=1";
			
			statementObj.execute(sql);
			
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		response.sendRedirect("AdminContactDetails");
	}

}
