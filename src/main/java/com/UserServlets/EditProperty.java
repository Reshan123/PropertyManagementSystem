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

import com.PropertyManagementSystem.GetConnection;
import com.PropertyManagementSystem.Property;
import com.PropertyManagementSystem.User;


public class EditProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get property id from the myProperty jsp 
		int PID = Integer.parseInt(request.getParameter("PID"));
		Property property = null;
		//getting database connection 
		Statement statementObj = GetConnection.getConnection();
		String sql = "SELECT * FROM property WHERE ID=" + PID;
		
		//getting all the property table data for the requested property id and setting a new property object
		try {
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			if (resultSetObj.next()) {
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
				
				property =new Property(PropertyID,PropertyName,Address,Description,Price,NoOfBathrooms,NoOfKitchens,NoOfRooms,Area,MainImage,user.getUsername(),user.getEmail());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//set property object to request object
		request.setAttribute("EditProperty", property);
		//redirect to create listing jsp
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("createListing.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
