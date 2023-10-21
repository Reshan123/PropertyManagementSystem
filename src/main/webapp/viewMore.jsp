<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page
	import="com.PropertyManagementSystem.*"
%>

<% Property house = (Property) request.getAttribute("house");
	if (house == null){
		response.sendRedirect("IndexDetails");
		return;
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>more details</title>
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    
    <style>
    body{
    	margin:0;
    	padding: 0;
    }
    </style>
</head>
<body>
    <%@ include file="includes/header.jsp" %>
    <div style="height:500px">
    	<%= request.getParameter("propertyID") %>
    </div>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>