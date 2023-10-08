package com.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PropertyManagementSystem.ContactDetails;

@WebServlet("/Admin/AdminContactDetails")
public class AdminContactDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static String url = "jdbc:mysql://localhost:3306/propertymanagementsystem";
	static String DBusername = "root";
	static String DBpassword = "";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactDetails contact = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "SELECT * FROM contact";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			if(resultSetObj.next()) {
				int ContactID = resultSetObj.getInt(1);
				String Description = resultSetObj.getString(2);
				String Phone = resultSetObj.getString(3);
				String Email = resultSetObj.getString(4);
				String Address = resultSetObj.getString(5);
				
				contact = new ContactDetails(ContactID,Description,Phone,Email,Address);
			}
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		request.setAttribute("AdminContactDetails", contact);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("adminContactDetails.jsp");
		reqDis.forward(request, response);
	}

}
