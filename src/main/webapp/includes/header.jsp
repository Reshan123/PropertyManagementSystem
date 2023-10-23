<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.PropertyManagementSystem.User" %>

<div class="navbar">
    <img src="images/logo.png" class="logo">

    <ul>
        <li class="navItem"><a href="IndexDetails">Home</a> </li>
        <li class="navItem"><a href="#AboutUs">About</a> </li>
        <li class="navItem"><a href="Contact">Contact</a> </li>
        <li class="navItem"><a href="GetPropertyDetails">Properties</a> </li>
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
                <a href="myProperties.jsp">My Properties</a>
                <a href="createListing.jsp">Create Listing</a>
                <a href="Logout" onclick="confirmLogout()">Log Out</a>
            </div>
        </li>
        <% } %>
    </ul>
</div>

<script>
	function confirmLogout(){
		return confirm("Are you sure you want to log out?");
	}
</script>