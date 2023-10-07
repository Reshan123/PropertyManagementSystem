<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="web videos\favicon.ico" />
    <title>Create</title>


    <link rel="stylesheet" href="css/styleSheet.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">

</head>

<body>
    <%@ include file="includes/header.jsp" %>
    <section>

        <div class="login-box">
            <form action="Signin" method="post">
                <h2>Sign Up</h2>
                <div class="input-box">
                    <input type="text" id="username" name="username" required>
                    <label>Username</label>
                </div>
                <div class="input-box">
                    <input type="email" id="emailS" name="email" required>
                    <label>Email</label>
                </div>

                <div class="input-box">
                    <input type="password" id="passwordS" name="password" required>
                    <label>Password</label>
                </div>

                <div class="input-box" id="input-box">
                    <input type="password" id="passwordSConfirm" name="passwordSConfirm" required oninput="validateSignin()">
                    <label id="input-lable">Confirm password</label>
                </div>

                <button name="sign" id="sign" class="logBtn">Sign Up</button>
        </div>

        </form>

        </div>
    </section>


    <%@ include file="includes/footer.jsp" %>
	<script src="js/confirmPassword.js"></script>
</body>

</html>