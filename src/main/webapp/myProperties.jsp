<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Properties</title>
<link rel="stylesheet" href="css/styleSheet.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/myProperties.css">
</head>
<body>
<%@page import="java.util.*" import="com.PropertyManagementSystem.*" %>

<%
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.jsp");
		return;
	}
	List<Property> PropertyList = (List<Property>) request.getAttribute("LoggedInUserPropertyList"); 
	if (PropertyList == null){
		response.sendRedirect("GetLoggedUserProperty");
		return;
	}
%>

	<%@ include file="includes/header.jsp" %>
	
	<div class="container">

        <div class="list-containder">
            <% for(Property house : PropertyList){ %>
            	<div class="house" >
	                <div class="house-img">
	                    <img src="images/<%= house.getMainImage() %>">
	                </div>
	
	                <div class="house-info">
	                    <p><%= house.getAddress() %></p>
	                    <h3><%= house.getPropertyName() %></h3>
	                    <p><%= house.getArea() %> sqft | Room Count : <%= house.getRooms() %></p>
	                    <div class="house-price">
	                        <div>
	                        	<form method="post" action="viewMore.jsp">
	                        		<button type="submit" name="propertyID" value=<%= house.getID() %> id="name" class="buttonListing">View More</button>
		                        </form>
		                        <button type="submit" id="name" class="buttonListing" onclick="location.href = 'EditProperty?PID=<%= house.getID() %>';">Edit</button>
	                        </div>
	                        <h4><%= house.getPrice() %> LKR</h4>
	                    </div>
	                </div>
	            </div>
            <% } %>
        </div>
    </div>
         <div class="pagination">
            <img src="images/arrow.png">
            <span>1</span>
            <span>2</span>
            <span>3</span>
            <span>4</span>
            <span>5</span>
            <span>&middot; &middot; &middot; &middot;</span>
            <span>12</span>
            <img src="images/arrow.png" class="rArr">

        </div>
	
	<%@ include file="includes/footer.jsp" %>

</body>
</html>