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

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		int UID = user.getUID();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String newPassword = request.getParameter("passwordNew");
		String pwdSession = user.getPassword();
		User NewUser;
		
		if (newPassword == null) {
			NewUser = Validate.update(UID, username, pwdSession , email);
		} else {
			NewUser = Validate.update(UID, username, newPassword, email);
		}
		
		
		session.setAttribute("user", NewUser);
		response.sendRedirect("preferences.jsp");
		
	}

}
