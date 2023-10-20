package com.AdminServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if (username.equals("admin") && password.equals("admin")) {
			
			session.setAttribute("AdminUserLogged", "Logged In");
			response.sendRedirect("AdminIndex");
			return;
			
		} else {
			
			session.setAttribute("AdminLoginError", "Invalid Credentials");
			response.sendRedirect("adminLogin.jsp");
			
			
		}
	}

}
