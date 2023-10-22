<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String userCount = (String) session.getAttribute("UserCount");
	String PropertyCount = (String) session.getAttribute("PropertyCount");
	if (userCount == null || PropertyCount == null){
		response.sendRedirect("IndexDetails");
		return;
	}
	System.out.print(userCount);
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
            <button type="button" class="index-btn"><span></span>View Listing</button>
        </div>
    </div>

    <div class="CardSection">
        <div class="CardContainer">
            <div class="card">
                <div class="title">
                    Total Properties Listed
                </div>
                <div class="count">
                    <%= PropertyCount %>
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
    
    
    <div class="AboutUs" id="AboutUs">
        <h1>About Us</h1>
        <!-- <hr> -->
        <div class="AboutUsCont">

            <div class="AboutUsCont-img">
                <img src="images/team.png">
            </div>

            <div class="AboutUsCont-body">
                <p>Welcome to our online property management system!<br>We are a dedicated team of professionals
                    committed to simplifying the complexities of property management.<br>Our platform has been
                    meticulously designed to streamline every aspect of property ownership, from rent collection to
                    maintenance requests.<br>With a passion for efficiency and a focus on customer satisfaction, we have
                    developed an intuitive and user-friendly interface that allows property owners, tenants, and
                    property managers to effortlessly navigate their real estate responsibilities.<br>Whether you're a
                    landlord looking for an all-in-one solution or a tenant seeking a convenient portal for
                    communication and payments, our property management system has you covered.<br>Join us in redefining
                    the property management experience for a more connected and hassle-free future.</p>


            </div>

        </div>

        <hr>

        <h2>What we do</h2>
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
                <div class="body"><h>This is a dummy text for filling out spaces. Just some random words...</h></div>
            </div>
            <div class="service">
                <div class="icon">
                    <img src="images/icon/Listing.png" alt="icon">
                </div>
                <div class="title">Property Listing</div>
                <div class="body"><h>This is a dummy text for filling out spaces. Just some random words...</h></div>
            </div>
            <div class="service">
                <div class="icon">
                    <img src="images/icon/Legal.png" alt="icon">
                </div>
                <div class="title">Legal Investment</div>
                <div class="body"><h>This is a dummy text for filling out spaces. Just some random words...</h></div>
            </div>
        </div>
        <!-- <hr> -->
    </div>

	<%@ include file="includes/footer.jsp" %>
    
    </body>

</html>