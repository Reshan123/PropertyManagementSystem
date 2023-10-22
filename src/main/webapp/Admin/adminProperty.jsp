<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.PropertyManagementSystem.*" import="java.util.*" %>

<%
	List<Property> AdminPropertyList = (List<Property>) request.getAttribute("AdminPropertyList");
	if (AdminPropertyList == null){
		response.sendRedirect("AdminPropertDetails");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adminIndex.css">
<link rel="stylesheet" href="css/adminProperty.css">
</head>
<body>
	<%@ include file="includes/include.jsp" %>
	
		<div class="MainContainer">
            <div class="dashboard">
            	<div class="welcomeText">
                    <h1>Property Details</h1>
                 </div>
            	<div class="CardContainer">
            		<table>
            			<tr>
            				<th>Property Name</th>
            				<th>Address</th>
            				<th>Description</th>
            				<th>Price</th>
            				<th>Rooms</th>
            				<th>Area</th>
            				<th>By</th>
            			</tr>           			
            			
            			<% for (Property house : AdminPropertyList){ %>
            				<tr>
            					<td><%= house.getPropertyName() %></td>
            					<td><%= house.getAddress() %></td>
            					<td style="text-align:justify;width:10%"><%= house.getDescription() %></td>
            					<td><%= house.getPrice() %> LKR</td>
            					<td><%= house.getRooms() %></td>
            					<td><%= house.getArea() %> Sqft</td>
            					<td><%= house.getUserName() %></td>
            				</tr>
            			<% } %>
            		</table>
            	</div>
            </div>
        </div>
</body>
</html>