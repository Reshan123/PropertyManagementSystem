package com.UserServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.User;

public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get session from request 
		HttpSession session = request.getSession();
		//get user session from session
		User user = (User) session.getAttribute("user");
		//get all inputs from the preferences page
		int UID = user.getUID();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String newPassword = request.getParameter("passwordNew");
		String pwdSession = user.getPassword();
		User NewUser;
		
		//checking if they have updated the password and executing the required sql statement
		if (newPassword == null) {
			NewUser = Validate.update(UID, username, pwdSession , email);
		} else {
			NewUser = Validate.update(UID, username, newPassword, email);
		}
		
		//setting the updated user session
		session.setAttribute("user", NewUser);
		//redirect to preferences jsp page
		response.sendRedirect("preferences.jsp");
		
	}

}
