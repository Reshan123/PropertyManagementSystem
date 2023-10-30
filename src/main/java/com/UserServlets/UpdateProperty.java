package com.UserServlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;

public class UpdateProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get all the property inputs from the property insert page
		int PID = Integer.parseInt(request.getParameter("PID"));
		String PropertyName = request.getParameter("Title");
		String Address = request.getParameter("Address");
		String Description = request.getParameter("Description");
		String Price = request.getParameter("Price");
		String HouseSize = request.getParameter("HouseSize");
		int Bedrooms = Integer.parseInt(request.getParameter("Bedrooms"));
		int Bathrooms = Integer.parseInt(request.getParameter("Bathrooms"));
		int Kitchens = Integer.parseInt(request.getParameter("Kitchens"));
		
		// getting connection for database
		Statement statementObject = GetConnection.getConnection();
		String sql = "UPDATE `property` SET propertyName='"+PropertyName+"',address='"+Address+"',description='"+Description+"',price='"+Price+"',bathroom="+Bathrooms+",kitchen="+Kitchens+",rooms="+Bedrooms+",area='"+HouseSize+"' WHERE ID="+PID;
		
		//executing sql 
		try {
			statementObject.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//redirect to my properties page
		response.sendRedirect("myProperties.jsp");
		return;
		
	}

}
