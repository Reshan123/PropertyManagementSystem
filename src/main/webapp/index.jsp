<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<htmL>

<head>
    <link rel="stylesheet" href="css/styleSheet.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <title>HomePage</title>
</head>

<body>

	<%@ include file="includes/header.jsp" %>
    
    <div class="header">
        <h1>Your Property, Our Passion</h1>
        <p>Discover Your Dream Home or Unlock the Value of
            Your Property with Our Comprehensive Buying and Selling Services.
            <br>Join the Journey Towards Your Property Goals Today!.
        </p>
        <div>
            <button type="button"><span></span>Get Started</button>
            <button type="button"><span></span>View Listing</button>
        </div>
    </div>

    <div class="CardSection">
        <div class="CardContainer">
            <div class="card">
                <div class="title">
                    Total Properties Listed
                </div>
                <div class="count">
                    5
                </div>
            </div>
            <div class="card">
                <div class="title">
                    Properties Available for Sale
                </div>
                <div class="count">
                    2
                </div>
            </div>
            <div class="card">
                <div class="title">
                    Number of Registered Users
                </div>
                <div class="count">
                    10
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