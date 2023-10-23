package com.UserServlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.*;


public class CreateProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		String PropertyName = request.getParameter("Title");
		String Address = request.getParameter("Address");
		String Description = request.getParameter("Description");
		String Price = request.getParameter("Price");
		String HouseSize = request.getParameter("HouseSize");
		int Bedrooms = Integer.parseInt(request.getParameter("Bedrooms"));
		int Bathrooms = Integer.parseInt(request.getParameter("Bathrooms"));
		int Kitchens = Integer.parseInt(request.getParameter("Kitchens"));
		
		
		Statement statementObject = GetConnection.getConnection();
		String sql = "INSERT INTO `propertymanagementsystem`.`property` (`propertyName`, `address`, `description`, `price`, `bathroom`, `kitchen`, `rooms`, `area`, `UserID`, `mainImageName`) VALUES ( '"+PropertyName+"', '"+Address+"', '"+Description+"', '"+Price+"', "+Bathrooms+", "+Kitchens+", "+Bedrooms+", "+HouseSize+", "+user.getUID()+", 'house-5.png')";
		
		try {
			statementObject.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("GetPropertyDetails");
		return;
	}

}
