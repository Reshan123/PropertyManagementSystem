package com.AdminServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.*;
import com.UserServlets.Validate;


public class AdminPropertDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement statementObject = GetConnection.getConnection();
		String sql="SELECT * FROM property";
		
		List<Property> AdminPropertyList = new ArrayList<>();
		
		try {
			ResultSet resultSetObject = statementObject.executeQuery(sql);
			while (resultSetObject.next()) {
				String username = Validate.getUserName(resultSetObject.getInt(8));
				AdminPropertyList.add(new Property(resultSetObject.getInt(1),resultSetObject.getString(2),resultSetObject.getString(3),resultSetObject.getString(4),resultSetObject.getString(5),resultSetObject.getInt(6),resultSetObject.getString(7),resultSetObject.getString(9),username));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("AdminPropertyList", AdminPropertyList);
		RequestDispatcher ReqDispatcher = request.getRequestDispatcher("adminProperty.jsp");
		ReqDispatcher.forward(request, response);
		
	}

	

}
