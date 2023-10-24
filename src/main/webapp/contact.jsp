<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Contact Us</title>
	<link rel="stylesheet" href="css/contact.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/styleSheet.css">
</head>
<body>
<%@ page import="com.PropertyManagementSystem.*" %>
<%
	ContactDetails contact = (ContactDetails) session.getAttribute("contact");
	if(contact == null){
		response.sendRedirect("Contact");
		return;
	}
%>

	<%@ include file="includes/header.jsp" %>
	
	
	<section class="contact">
        <div class="container contact_container">
            <aside class="contact_aside">
                <div class="aside_image">
                    <img src="images\contact.png">
                </div>
                
            </aside>

            <!-- <h1>Send us Feedback</h1> -->
            <div class="contactRight">
                <h1>Contact Us</h1>
                <p><%= contact.getDescription() %></p>
                <ul class="contact_details">
                    <li>
                        <i class="uil-phone-times"></i>
                        <p><%= contact.getAddress() %></p>
                    </li>
                    <li>
                        <i class="uil uil-envelope"></i>
                        <p><%= contact.getEmail() %></p>
                    </li>
                    <li>
                        <i class="uil-location-point"></i>
                        <p><%= contact.getPhone() %></p>
                    </li>
                </ul>

            </div>



        </div>
    </section>
    
    <%@ include file="includes/footer.jsp" %>
</body>
</html>