<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String UserCount = (String) request.getAttribute("UserCount");
	String PropertyCount = (String) request.getAttribute("PropertyCount");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/adminIndex.css">
    <title>Admin Dashboard</title>
</head>
<body>    

	<%@ include file="includes/include.jsp" %>
	
        <div class="MainContainer">
            <div class="dashboard">
                <div class="welcomeText">
                    <h1>Welcome Admin!</h1>
                    <p>Dashboard</p>
                </div>
                <div class="CardContainer">
                    <div class="Card">
                        <div class="image">
                            <img src="images/user-profile-min.png" alt="User">
                        </div>
                        <div class="text">
                            Registered Users
                        </div>
                        <div class="count">
                            <%= UserCount %>
                        </div>
                    </div>
                    <div class="Card">
                        <div class="image">
                            <img src="images/user-profile-min.png" alt="User">
                        </div>
                        <div class="text">
                            Listed Properties
                        </div>
                        <div class="count">
                            <%= PropertyCount %>
                        </div>
                    </div>
                    <div class="Card">
                        <div class="image">
                            <img src="images/user-profile-min.png" alt="User">
                        </div>
                        <div class="text">
                            Active Properties
                        </div>
                        <div class="count">
                            0
                        </div>
                    </div>
                </div>
            </div>
        </div>

</body>
</html>