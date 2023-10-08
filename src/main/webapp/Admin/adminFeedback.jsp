<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page 
	import="com.PropertyManagementSystem.*"
	import="java.util.*"
%>

<%
	List<FeedbackDetails> feedbackList = (List<FeedbackDetails>) request.getAttribute("FeedbackList");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/adminIndex.css">
		<link rel="stylesheet" href="css/adminFeedbackDetails.css">
	</head>
	<body>
		
		<%@ include file="includes/include.jsp" %>
		
		<div class="MainContainer">
			<div class="dashboard">
				<div class="CardContainer">
					<table>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Message</th>
						</tr>
						<% for(FeedbackDetails feedback : feedbackList){ %>
							<tr>
								<td style="padding-bottom:20px"><%= feedback.getFname() %></td>
								<td style="padding-bottom:20px"><%= feedback.getLname() %></td>
								<td style="padding-bottom:20px"><%= feedback.getEmail() %></td>
								<td style="padding-bottom:20px"><%= feedback.getMessage() %></td>
							</tr>
						<% } %>
					</table>
				</div>
			</div>
		</div>
		
	</body>
</html>