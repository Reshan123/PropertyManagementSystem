<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sign In</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/adminlogin.css">
    <link rel="stylesheet" href="../css/styleSheet.css">
</head>
<body>
	<section>

        <div class="login-box">

            <form method="post" action="AdminSignIn">
                <h2>Admin Login</h2>
                    <div class="input-box">
                        <input type="text"  id="username" name="username" required>
                      	<label>Username</label>
                    </div>
                    <div class="input-box">
                        <input type="email"  id="email" name="email" required>
                      	<label>Email</label>
                    </div>
                    <div class="input-box">
                        <input type="password" id="passwordInput" onChange="passwordLengthCheck()" id="password" name="password" required>
                        <label>Password</label>
                    </div>

                    <button type="submit" class="logBtn">Submit</button>

            </form>
        </div>

    </section>
    <script src="js/app.js"></script>
</body>
</html>