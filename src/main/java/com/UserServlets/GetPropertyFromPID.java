package com.UserServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.*;


public class GetPropertyFromPID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int PID = Integer.parseInt(request.getParameter("PID"));
		
		Property house = null;
		
		Statement statementObject = GetConnection.getConnection();
		String sql = "SELECT * FROM property WHERE ID=" + PID;
		
		try {
			ResultSet resultSetObj = statementObject.executeQuery(sql);
			
			if(resultSetObj.next()) {
				
				int PropertyID = resultSetObj.getInt(1);
				String PropertyName = resultSetObj.getString(2);
				String Address = resultSetObj.getString(3);
				String Description = resultSetObj.getString(4);
				String Price = resultSetObj.getString(5);
				int NoOfBathrooms = resultSetObj.getInt(6);
				int NoOfKitchens = resultSetObj.getInt(7);
				int NoOfRooms = resultSetObj.getInt(8);
				String Area = resultSetObj.getString(9);
				int UID = resultSetObj.getInt(10);
				String MainImage = resultSetObj.getString(11);
				
				User user = Validate.getUserFromID(UID);
				
				house = new Property(PropertyID,PropertyName,Address,Description,Price,NoOfBathrooms,NoOfKitchens,NoOfRooms,Area,MainImage,user.getUsername(),user.getEmail());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("editProperty", house);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
		requestDispatcher.forward(request, response);
		
	}

}
