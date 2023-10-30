package com.UserServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.Property;
import com.PropertyManagementSystem.User;
import com.PropertyManagementSystem.GetConnection;

public class GetPropertyDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// create a list to store property objects
		List <Property> PropertyList = new ArrayList<Property>();
		
		Statement statementObj = null;
		try {
			//getting database connection
			statementObj = GetConnection.getConnection();
			//excute sql statement
			String sql = "SELECT * FROM property";
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			//get all the property details and add to the list
			while(resultSetObj.next()) {
				
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
				
				PropertyList.add(new Property(PropertyID,PropertyName,Address,Description,Price,NoOfBathrooms,NoOfKitchens,NoOfRooms,Area,MainImage,user.getUsername(),user.getEmail()));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//getting session and setting property list to a session 
		HttpSession session = request.getSession();
		session.setAttribute("PropertyList", PropertyList);
		
		//redirect to listing jsp
		response.sendRedirect("listing.jsp");
		
	}

}
