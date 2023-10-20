<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%
	String error = (String) session.getAttribute("AdminLoginError");
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/adminlogin.css">
    <link rel="stylesheet" href="../css/styleSheet.css">
</head>
<body>
	<section>

        <div class="login-box">

            <form method="get" action="AdminLogin">
                <h2>Admin Login</h2>
				<% if (error != null){ %>
					<h2 style="background:white;color:red;"><%= error %></h2>
					<% session.setAttribute("AdminLoginError", null); %>
				<% } %>
                    <div class="input-box">
                        <input type="text"  id="username" name="username" required>
                      	<label>Username</label>
                    </div>
                    <div class="input-box">
                        <input type="password" id="password" name="password" required>
                        <label>Password</label>
                    </div>

                    <button type="submit" class="logBtn">Submit</button>

            </form>
        </div>

    </section>
</body>
</html>