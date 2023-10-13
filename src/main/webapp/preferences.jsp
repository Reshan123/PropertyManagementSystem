<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.PropertyManagementSystem.User" %>

<%	
	User userProfile = (User) session.getAttribute("user");
	if (userProfile == null){
		response.sendRedirect("login.jsp");
		return;
	}
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="css/pref.css">
    <link rel="stylesheet" href="css/styleSheet.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <title>Preferences</title>
</head>

<body>
    <%@ include file="includes/header.jsp" %>


    <div class="prefContainder">

        <div class="prefLeftContainer">

            <div class="prefLeft">

                <div class="prefUserInfo">
                    <img src="images/ProfileIcon.png" class="prefLeftImg" alt="user">
                    <h4><%= userProfile.getUsername() %></h4>
                </div>

                <div class="otherInfo">
                    <h2>Thanks to Us</h2>
                    <p>ur sorry-ass has another chance to fix your uglyass name</p>
                </div>
            </div>




        </div>

        <form class="prefRightContainer" method="post" action="EditProfile">
            <div class="prefRight">

                <div class="profForm" >
                    <h3>Username</h3>
                    <input type="text" class="input" placeholder="username" name="username" value="<%= userProfile.getUsername() %>">
                    <h3>New Password</h3>
                    <input type="password" class="input" placeholder="password" name="passworddNew" id="pwd">
                    <h3>Confirm New Password</h3>
                    <input type="password" class="input" placeholder="password" id="confirmPwd" oninput="validate()">
                    <h3>Email</h3>
                    <input type="email" class="input" placeholder="email@example.com" name="email" value=<%= userProfile.getEmail() %>>
                </div>

            </div>
            <div class="prefRightBtns">
                <button class="prefRightBtn">Cancel</button>
                <button class="prefRightBtn" type="submit">Confirm</button>

            </div>
        </form>

    </div>


    <%@ include file="includes/footer.jsp" %>
	<script src="js/confirmPassword.js"></script>


</body>

</html>