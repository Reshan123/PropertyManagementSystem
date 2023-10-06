<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.PropertyManagementSystem.User" %>

<div class="navbar">
    <img src="images/logo.png" class="logo">

    <ul>
        <li class="navItem"><a href="index.jsp">Home</a> </li>
        <li class="navItem"><a href="#">About</a> </li>
        <li class="navItem"><a href="contact.jsp">Contact</a> </li>
        <li class="navItem"><a href="listing.jsp">Properties</a> </li>
        <% 
			User user = (User) session.getAttribute("user");
			if (user == null){
		%>
		<li class="navItem"><a href="login.jsp">login</a> </li>
        
        <% } else { %>
        <li class="dropdown">
            <button class="dropbtn">Profile</button>
            <div class="dropdown-content">
                <a href="preferences.jsp">Preferences</a>
                <a href="#">My Properties</a>
                <a href="Logout">Log Out</a>
            </div>
        </li>
        <% } %>
    </ul>
</div>