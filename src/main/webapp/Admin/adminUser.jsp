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
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/adminIndex.css">
		<link rel="stylesheet" href="css/adminUserDetails.css">
	</head>
	<body>
		<%@ include file="includes/include.jsp" %>
		
		<div class="MainContainer">
            <div class="dashboard">
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
								<td><form><button>Edit</button><button>Delete</button></form></td>					
							</tr>
						<% } %>
					</table>
				</div>
            </div>
        </div>
		
	
	</body>
</html>