package com.AdminServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.AdminUser;
import com.PropertyManagementSystem.GetConnection;

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		
		HttpSession session = request.getSession();
		AdminUser user = null;
		
		Statement statementObject = GetConnection.getConnection();
		String sql = "SELECT * FROM admins WHERE email='"+email+"' AND password='"+password+"'";
		ResultSet resultSetObj;
		try {
			resultSetObj = statementObject.executeQuery(sql);
			if(resultSetObj.next()) {
				String usernameDB = resultSetObj.getString(2);
				String emailDB = resultSetObj.getString(3);
				String passwordDB = resultSetObj.getString(4);
				
				user = new AdminUser(usernameDB,emailDB,passwordDB);
			} else {

				session.setAttribute("AdminLoginError", "Invalid Credentials");
				response.sendRedirect("adminLogin.jsp");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("adminUser", user);
		
		response.sendRedirect("AdminIndex");
	}

}
