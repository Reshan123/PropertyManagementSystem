package com.UserServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PropertyManagementSystem.Property;
import com.PropertyManagementSystem.GetConnection;

public class GetPropertyDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <Property> PropertyList = new ArrayList<Property>();
		
		Statement statementObj = null;
		try {
			statementObj = GetConnection.getConnection();
	
			String sql = "SELECT * FROM property";
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
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
				
				String UserName = Validate.getUserName(UID);
				
				PropertyList.add(new Property(PropertyID,PropertyName,Address,Description,Price,NoOfRooms,Area,MainImage,UserName));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("PropertyList", PropertyList);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("listing.jsp");
		reqDis.forward(request, response);
		
	}

}
