package com.UserServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.User;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getting email and password from the login jsp 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// get user from the login in validate class
		User user = Validate.login(email , password);
		
		// get session from the request object
		HttpSession session = request.getSession();
		
		//sending error msg if the login is invalid
		if (user == null) {
			session.setAttribute("errorLogIn", "Invalid Credentials");
			response.sendRedirect("login.jsp");
			return;
		}
		
		//setting user session
		session.setAttribute("user", user);
		//redirect to index jsp
		response.sendRedirect("index.jsp");
	}

}
