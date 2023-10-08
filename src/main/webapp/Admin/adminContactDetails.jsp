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
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/adminIndex.css">
		<link rel="stylesheet" href="css/adminContactDetails.css">
	</head>
	<body>
	
		<%@ include file="includes/include.jsp" %>
		
		<div class="MainContainer">
		
			<div class="Dashboard">
				<div class="CardContainer">
					<form method="get" action="UpdateContactDetails">
						<table>
							<tr>
								<th>Description</th>
								<th>Phone</th>
								<th>Email</th>
								<th>Address</th>
								<th rowspan=2><button type="submit">Edit</button></th>
							</tr>
							<tr>
								<td><textarea name="description" rows="10" style="width:95%"><%= contact.getDescription() %></textarea></td>
								<td><input type="text" name="phone" value=<%= contact.getPhone() %>  /></td>
								<td><input type="email" name="email" value=<%= contact.getEmail() %> style="width:95%"/></td>
								<td><textarea name="address" rows="5" style="width:95%"><%= contact.getAddress() %></textarea></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			
		</div>
		
	</body>
</html>