<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<% String error = (String) session.getAttribute("errorLogIn"); %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" type="image/x-icon" href="web videos\favicon.ico"/>
  <title>Login </title>

  <link rel="stylesheet" href="css/login.css">
  <link rel="stylesheet" href="css/styleSheet.css">
  <link rel="stylesheet" href="css/footer.css">
  <link rel="stylesheet" href="css/header.css">
</head>

<body>

    <%@ include file="includes/header.jsp" %>

<!--Frist we have to creat registration form-->
<section>
  
<div class="login-box">

  <form action="Login" method="post"> 
    <h2>Login</h2>
    
    <% if (error != null){ %>
   		 <p style="color:red;text-align:center;font-size:1.5em;background:white;border-radius:5px"> 
   		 <%= error %>
   		 <% 
	   		 session.setAttribute("errorLogIn" , null);
   		 %>
   		 </p>
    <% } %>
    
    <div class="input-box">
      <input type="email"  id="email" name="email" required>
      <label>Email</label>
    </div>

    <div class="input-box">
      <input type="password" id="password" name="password" required>
      <label>Password</label>
    </div>

    

    <div class="remember-forgot">
       <label><input type="checkbox">Remember me</label>
       <a href="pwForget.html">Forgot Password?</a>
    </div>

    <button name="login" id="login" class="logBtn">Login</button>
    <div class="register-link">
      <p>Don't have an account? <a href="signin.jsp">Register</a></p>
    </div>
   
  </form>
</div>

</section>



<%@ include file="includes/footer.jsp" %>


</body>
</html>

