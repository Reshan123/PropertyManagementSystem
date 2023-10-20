package com.UserServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.GetConnection;
import com.PropertyManagementSystem.Property;

public class GetAllPropertyDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String PID = request.getParameter("propertyID");
		Property house = null;
		
		Statement statementObj = GetConnection.getConnection();
		String sql = "SELECT * FROM property WHERE ID = " + PID;
		
		ResultSet resultSetObj;
		try {
			resultSetObj = statementObj.executeQuery(sql);
			while(resultSetObj.next()) {
				
				int PropertyID = resultSetObj.getInt(1);
				String PropertyName = resultSetObj.getString(2);
				String Address = resultSetObj.getString(3);
				String Description = resultSetObj.getString(4);
				String Price = resultSetObj.getString(5);
				int NoOfRooms = resultSetObj.getInt(6);
				String Area = resultSetObj.getString(7);
				int UID = resultSetObj.getInt(8);
				String MainImage = resultSetObj.getString(9);
				
				String UserName = Validate.getUser(UID);
				
				house = new Property(PropertyID,PropertyName,Address,Description,Price,NoOfRooms,Area,UserName,MainImage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("house", house);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewMore.jsp");
		dispatcher.forward(request, response);
		
	}

}
