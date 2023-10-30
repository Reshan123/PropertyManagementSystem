package com.UserServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.*;

public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get inputs from the sign in page
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		// getting user object from the validate class using signin method
		User user = Validate.signin(username, password, email);
		
		//getting session from request
		HttpSession session = request.getSession();
		//setting user session
		session.setAttribute("user", user);
		//redirect to index page
		response.sendRedirect("index.jsp");
	}

}
