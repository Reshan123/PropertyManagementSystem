package com.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.User;
import com.PropertyManagementSystem.Validate;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = Validate.login(email , password);
		
		HttpSession session = request.getSession();
		
		if (user == null) {
			session.setAttribute("errorLogIn", "Invalid Credentials");
			response.sendRedirect("login.jsp");
			return;
		}
		
		
		session.setAttribute("user", user);
		
		response.sendRedirect("index.jsp");
	}

}
