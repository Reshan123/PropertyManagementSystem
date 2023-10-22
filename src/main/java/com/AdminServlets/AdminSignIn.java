package com.AdminServlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.AdminUser;
import com.PropertyManagementSystem.GetConnection;

public class AdminSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Statement statementObject = GetConnection.getConnection();
		
		String sql = "INSERT INTO admins (username , email , password) VALUES ('"+username+"','"+email+"','"+password+"')";
		try {
			statementObject.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		AdminUser adminUser = new AdminUser(username,email,password);
		HttpSession session = request.getSession();
		session.setAttribute("adminUser", adminUser);
		response.sendRedirect("AdminIndex");
	}

}
