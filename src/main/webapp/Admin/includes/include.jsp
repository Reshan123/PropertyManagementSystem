<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="com.PropertyManagementSystem.*" %>
<% 
	AdminUser Adminuser = (AdminUser) session.getAttribute("adminUser");
	if (Adminuser == null){
		response.sendRedirect("adminLogin.jsp");
		return;
	}
%>
  
<nav>
        <div class="logo">
            <img src="images/logo.png" alt="">
        </div>
        <div class="text">
        	<%= Adminuser.getUsername() %>
            <img src="images/ProfileIcon.png" alt="">
            <button onClick="location.href = 'AdminLogout';">Logout</button>
        </div>
    </nav>

    <div class="body">
        <div class="SideContainer">
            <div class="ElementContainer">
                <a href="AdminIndex">
                    <img src="images/icon/Legal.png" alt="">
                    Dashboard
                </a>
                <a href="AdminUserDetails">
                    <img src="images/icon/Legal.png" alt="">
                    All Users
                </a>
                <a href="adminProperty.jsp">
                    <img src="images/icon/Legal.png" alt="">
                    Properties
                </a>
                <a href="AdminContactDetails">
                    <img src="images/icon/Legal.png" alt="">
                    Contact Details
                </a>           
                <div class="feedback">
                	<img src="images/icon/Legal.png" alt="">
                	<p>Feedback</p>
                	<div>
	                	<a href="AdminFeedbackReg">
		                    Registered User
		                </a>
		                <a href="AdminFeedback">	                    
		                    Unregistered user
		                </a>
	                </div>                    
                </div>
            </div>
        </div>