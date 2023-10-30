package com.UserServlets;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;

@WebServlet("/DeleteProperty")
public class DeleteProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int PID = Integer.parseInt(request.getParameter("propertyID"));
		
		Statement statementObj = null;
		//get connection and execute the sql
		try {
			
			statementObj = GetConnection.getConnection();
			String sql = "DELETE FROM property WHERE ID = " + PID;
			
			statementObj.execute(sql);			
			
			
		} catch (Exception e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		//redirect to contact page
		response.sendRedirect("myProperties.jsp");
		
	}

}
