package com.UserServlets;

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
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.*;


public class GetLoggedUserProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		
		Statement statementObject = GetConnection.getConnection();
		String sql="SELECT * FROM property WHERE UserID =" + userSession.getUID();
		
		List<Property> PropertyList = new ArrayList<>();
		
		try {
			ResultSet resultSetObject = statementObject.executeQuery(sql);
			while (resultSetObject.next()) {
				User user = Validate.getUserFromID(resultSetObject.getInt(10));
				PropertyList.add(new Property(resultSetObject.getInt(1),resultSetObject.getString(2),resultSetObject.getString(3),resultSetObject.getString(4),resultSetObject.getString(5),resultSetObject.getInt(6),resultSetObject.getInt(7),resultSetObject.getInt(8),resultSetObject.getString(9),resultSetObject.getString(11),user.getUsername(),user.getEmail()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("LoggedInUserPropertyList", PropertyList);
		RequestDispatcher ReqDispatcher = request.getRequestDispatcher("myProperties.jsp");
		ReqDispatcher.forward(request, response);
		
	}

	

}
