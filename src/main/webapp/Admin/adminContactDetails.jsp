<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="com.PropertyManagementSystem.ContactDetails" %>

<%
	ContactDetails contact = (ContactDetails) request.getAttribute("AdminContactDetails");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin Dashboard</title>
		<link rel="stylesheet" href="css/adminIndex.css">
		<link rel="stylesheet" href="css/adminContactDetails.css">
	</head>
	<body>
	
		<%@ include file="includes/include.jsp" %>
		
		<div class="MainContainer">
		
			<div class="dashboard">
				<div class="CardContainer">
					<div class="welcomeText">
	                    <h1>Contact Details</h1>
	                    <p>Edit Contacr Details</p>
	                </div>
					<form method="get" action="UpdateContactDetails">
						<span>Description : </span><textarea name="description" rows="10"><%= contact.getDescription() %></textarea><br/>
						<span>Phone Number : </span><input type="text" name="phone" value=<%= contact.getPhone() %>  /><br/>
						<span>Email : </span><input type="email" name="email" value=<%= contact.getEmail() %>/><br/>
						<span>Address : </span><textarea name="address" rows="5"><%= contact.getAddress() %></textarea><br/>
						<button type="submit">Edit</button>
					</form>
				</div>
			</div>
			
		</div>
		
	</body>
</html>