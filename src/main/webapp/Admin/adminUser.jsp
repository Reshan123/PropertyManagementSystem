<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page 
	import="com.PropertyManagementSystem.*"
	import="java.util.*"
%>    

<%
	List<User> UserList = new ArrayList<User>();
	UserList = (List<User>) request.getAttribute("UserList");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin Dashboard</title>
		<link rel="stylesheet" href="css/adminIndex.css">
		<link rel="stylesheet" href="css/adminUserDetails.css">
	</head>
	<body>
		<%@ include file="includes/include.jsp" %>
		
		<div class="MainContainer">
            <div class="dashboard">
            	<div class="welcomeText">
                    <h1>User Details</h1>
                    <p>User management</p>
                </div>
            	<div class="CardContainer">
					<table>
						<tr>
							<th>User ID</th>
							<th>Username</th>
							<th>Email</th>
							<th></th>
						</tr>
						<% for(User user : UserList){ %>
							<tr>
								<td><%= user.getUID() %></td>
								<td><%= user.getUsername() %></td>
								<td><%= user.getEmail() %></td>
								<td><form method="post" action="DeleteUser"><button style="border:red solid 3px;color:red;" name="UserID" value=<%= user.getUID() %>>DELETE</button><button>Something Else</button></form></td>					
							</tr>
						<% } %>
					</table>
				</div>
            </div>
        </div>
		
	
	</body>
</html>