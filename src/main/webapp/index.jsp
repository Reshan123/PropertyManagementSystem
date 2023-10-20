<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String userCount = (String) session.getAttribute("UserCount");
	String propertyCount = (String) session.getAttribute("PropertyCount");
	if (userCount == null || propertyCount == null){
		response.sendRedirect("IndexDetails");
		return;
	}
%>

<!DOCTYPE html>
<htmL>

<head>
    <link rel="stylesheet" href="css/styleSheet.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/aniScroll.css">
    <script defer src="js/app.js"></script>
    <title>HomePage</title>
</head>

<body>

	<%@ include file="includes/header.jsp" %>
    
    <div class="header">

        <div class="tagline">
            <h1>Tomorrow, built today</h1>  
        </div>
            
        <p>Discover Your Dream Home or Unlock the Value of
            Your Property <br> with Our Comprehensive Buying and Selling Services.
            <br><br><br>Join the Journey Towards Your Property Goals Today!.
        </p>
        <div>
            <button type="button" class="index-btn"><span></span>Get Started</button>
            <button type="button" class="index-btn" onclick="javascript:location.href='GetPropertyDetails'"><span></span>View Listing</button>
        </div>
    </div>

    <div class="CardSection">
        <div class="CardContainer">
            <div class="card">
                <div class="title">
                    Total Properties Listed
                </div>
                <div class="count">
                    <%= propertyCount %>
                </div>
            </div>
            <div class="card">
                <div class="title">
                    Properties Available for Sale
                </div>
                <div class="count">
                    0
                </div>
            </div>
            <div class="card">
                <div class="title">
                    Number of Registered Users
                </div>
                <div class="count">
                    <%= userCount %>
                </div>
            </div>
        </div>
    </div>

    <div class="WhatWeDo">
        <p>What We Do</p>
        <div class="container">
            <div class="service">
                <div class="icon">
                    <img src="images/icon/Selling.png" alt="icon">
                </div>
                <div class="title">Selling Services</div>
                <div class="body">This is a dummy text for filling out spaces. Just some random words...</div>
            </div>
            <div class="service">
                <div class="icon">
                    <img src="images/icon/Rental.png" alt="icon">
                </div>
                <div class="title">Rental Services</div>
                <div class="body">This is a dummy text for filling out spaces. Just some random words...</div>
            </div>
            <div class="service">
                <div class="icon">
                    <img src="images/icon/Listing.png" alt="icon">
                </div>
                <div class="title">Property Listing</div>
                <div class="body">This is a dummy text for filling out spaces. Just some random words...</div>
            </div>
            <div class="service">
                <div class="icon">
                    <img src="images/icon/Legal.png" alt="icon">
                </div>
                <div class="title">Legal Investment</div>
                <div class="body">This is a dummy text for filling out spaces. Just some random words...</div>
            </div>
        </div>
        
    </div>

	<%@ include file="includes/footer.jsp" %>
    
    </body>

</html>