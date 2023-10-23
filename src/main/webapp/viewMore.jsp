<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page
	import="com.PropertyManagementSystem.*"
	import="java.util.*"
%>

<% 
	List<Property> PropertyList = (List<Property>) session.getAttribute("PropertyList");
	String houseID = request.getParameter("propertyID");
	if (PropertyList == null){
		response.sendRedirect("GetPropertyDetails");
		return;
	} 
	
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>more details</title>
    <link rel="stylesheet" href="css/pref.css">
    <link rel="stylesheet" href="css/styleSheet.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/viewMore.css">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

    <script src="js/jquery.hislide.js"></script>
    
    <style>
    body{
    	margin:0;
    	padding: 0;
    }
    </style>
</head>
<body>
    <%@ include file="includes/header.jsp" %>
    
    
    <div class="viewMore-container">
		<%
		for (Property house : PropertyList){
			String PropertyListHouseID = house.getID()+ "";
			if (houseID.equals(PropertyListHouseID)){%>
				
		        <div class="slide hi-slide">
		            <div class="hi-prev"></div>
		            <div class="hi-next"></div>
		
		            <ul>
		                <li><img src="images/house-2.png"></li>
		                <li><img src="images/house-3.png"></li>
		                <li><img src="images/house-4.png"></li>
		                <li><img src="images/house-5.png"></li>
		                <li><img src="images/house-2.png"></li>
		                <li><img src="images/house-3.png"></li>
		                <li><img src="images/house-4.png"></li>
		                <li><img src="images/house-5.png"></li>
		            </ul>
		
		        </div>
		
		
		        <div class="viewMore-info">
		
		            <!-- left  -->
		            <div class="viewMore-info-cont">
		
		
		                <!-- price and stuff -->
		
		                <div class="viewMore-info-left-cont1">
		
		
		                    <!-- --------------------------------- -->
		
		
		                    <div class="viewMore-info-text">
		                        <h1><%= house.getPropertyName() %></h1>
		                        <h3><%= house.getPrice() %> LKR</h3>
		                        <h3><%= house.getAddress() %> LKR</h3>
		    
		                        <p><%= house.getDescription() %></p>
		
		                    </div>
		                   
		
		                    <div class="viewMore-info-left-cont1-icons">
		                        <div class="moreInfo-box">
		                            <img src="images/bed.png" class="viewMore-icons">
		                            <p>Property Type : House</p>
		                        </div>
		                        <div class="moreInfo-box">
		                            <img src="images/bathroom.png" class="viewMore-icons">
		                            <p>Area : <%= house.getArea() %> Sqft</p>
		                        </div>
		                        <div class="moreInfo-box">
		                            <img src="images/measurement.png" class="viewMore-icons">
		                            <p>Property Age : 10 years</p>
		                        </div>
		
		                    </div>
		
		                </div>
		
		
		                <!-- Interior -->
		                <div class="viewMore-info-left-cont1">
		
		                    <div class="viewMore-info-text">
		                        <h1>Interior</h1>
		                    </div>
		
		                    <div class="viewMore-info-left-cont1-icons">
		                        <div class="moreInfo-box">
		                            <p></p>
		                            <p><%= house.getRooms() %> Bedrooms</p>
		                        </div>
		                        <div class="moreInfo-box">
		                            <img src="images/bathroom.png" class="viewMore-icons">
		                            <p><%= house.getBathrooms() %> Bathrooms</p>
		                        </div>
		                        <div class="moreInfo-box">
		                            <img src="images/measurement.png" class="viewMore-icons">
		                            <p><%= house.getKitchens() %> Kitchens</p>
		                        </div>
		
		                    </div>
		
		                </div>
		
		
		
		
		
		
		            </div>
		
		<!-- ------------------------ -->
		<!-- right -->
		
		            <div class="viewMore-info-cont">
		
		                <div class="viewMore-seller">
		
		                    <div class="seeMore-sellerInfo">
		                        <img src="images/ProfileIcon.png" class="sellerImg">
		                        <h2><%= house.getUserName() %></h2>
		                    </div>
		
		                    <!--   <div class="seeMore-sellerPara">
		                        <p></p>
		                    </div> -->
		
		                    <div class="viewMore-seller-icons" style="display:flex;flex-direction:column;">
		
		                        <div class="contactSeller">
		                            <img src="images/phone.png" class="viewMore-icons">
		                            <p>077-458-7895</p>	                  
		                        </div>
		                        <div class="contactSeller">
		                            <img src="images/phone.png" class="viewMore-icons">
		                            <p><%= house.getUserEmail() %></p>	                  
		                        </div>
		
		                    </div>
		
		                </div>
		            </div>
		
		        </div>
					
			<% } %>
		<% } %>
    </div>


    <script>
        $('.slide').hiSlide();
    </script>
    
    
    <%@ include file="includes/footer.jsp" %>
</body>
</html>