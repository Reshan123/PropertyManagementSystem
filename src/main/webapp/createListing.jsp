<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Listing</title>
<link rel="stylesheet" href="css/styleSheet.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/createListing.css">
</head>
<body>
	<%@page 
		import="com.PropertyManagementSystem.*"
	%>
	
	<%
		Property EditProperty = (Property) request.getAttribute("EditProperty");
	%>
	<%@ include file="includes/header.jsp" %>
	
		<div class="creListingCont">
			<% if (EditProperty == null){ %>
				<form method="post" action="CreateProperty">
			        <div class="createListingForm">
			            <h2 style="text-align: center;">Fill in the details</h2>
			            <h3>Title</h3>
			            <input type="text" class="Finput" placeholder="Keep it short!" required name="Title">
			            <h3>Address</h3>
			            <input type="text" class="Finput" name="Address" placeholder="Enter the street, house number, and/or post code.">
			            <h3>Description</h3>
			            <textarea class="Finput" id="w3review" name="Description" rows="4" cols="50"
			                placeholder="More details = More responses!" required></textarea>
			            <h3 id="priceText">Price</h3>
			            <input type="text" id="priceInput" class="Finput" name="Price" placeholder="Selling price" required onChange="validatePrice()">
			            <h3 id="sizeText">Hosue Size</h3>
			            <input type="text" id="sizeInput" onChange="validateSize()" class="Finput" name="HouseSize" placeholder="Size of the house in perches" required>
			            <div style="display:flex;gap:20px;">
			            	<div>
			            		<h3>Bedrooms</h3>
				            	<input type="number" class="Finput" name="Bedrooms" placeholder="Number of Bedrooms" required>
			            	</div>
				            <div>
				            	<h3>Bathrooms</h3>
					            <input type="number" class="Finput" name="Bathrooms" placeholder="Number of Bathrooms" required>
				            </div>
							<div>
								<h3>Kitchens</h3>
				            	<input type="number" class="Finput" name="Kitchens" placeholder="Number of Kitchens" required>
							</div>
			            </div>
			            
			            
			            <hr>
			            <h2 style="text-align: center;">Insert image</h2>
			
			            <div class="hero">
			
			                <label for="input-file" id="drop-area">
			                    <input type="file" accept="image/*" id="input-file" name="FILE" hidden>
			                    <div id="img-view">
			                        <img src="/images/upload.png">
			                        <p>Drag and drop or click here <br>to upload image</p>
			                    </div>
			                </label>     
			
			            </div>
			            <hr>
			            <div class="createListingConfirm">
			                <button class="createListingConfirmBtn" type="submit">Add Listing</button>
			                <button class="createListingConfirmBtn">Cancel</button>
			
			            </div>
			        </div>
			
				</form>
			<% } else { %>
				<form method="post" action="UpdateProperty">
			        <div class="createListingForm">
			            <h2 style="text-align: center;">Edit the details</h2>
			            <h3>Title</h3>
			            <input type="text" class="Finput" value="<%= EditProperty.getPropertyName() %>" placeholder="Keep it short!" required name="Title">
			            <h3>Address</h3>
			            <input type="text" class="Finput" value="<%= EditProperty.getAddress() %>" name="Address" placeholder="Enter the street, house number, and/or post code.">
			            <h3>Description</h3>
			            <textarea class="Finput" id="w3review" name="Description" rows="4" cols="50"
			                placeholder="More details = More responses!" required><%= EditProperty.getDescription() %></textarea>
			            <h3>Price</h3>
			            <input type="text" value="<%= EditProperty.getPrice() %>" class="Finput" name="Price" placeholder="Selling price" required>
			            <h3>Hosue Size</h3>
			            <input type="text" value="<%= EditProperty.getArea() %>" class="Finput" name="HouseSize" placeholder="Size of the house in perches" required>
			            <div style="display:flex;gap:20px;">
			            	<div>
			            		<h3>Bedrooms</h3>
				            	<input type="number" value="<%= EditProperty.getRooms() %>" class="Finput" name="Bedrooms" placeholder="Number of Bedrooms" required>
			            	</div>
				            <div>
				            	<h3>Bathrooms</h3>
					            <input type="number" value="<%= EditProperty.getBathrooms() %>" class="Finput" name="Bathrooms" placeholder="Number of Bathrooms" required>
				            </div>
							<div>
								<h3>Kitchens</h3>
				            	<input type="number" value="<%= EditProperty.getKitchens() %>" class="Finput" name="Kitchens" placeholder="Number of Kitchens" required>
							</div>
								<input type="text" name="PID" value="<%= EditProperty.getID() %>" style="display:none;">
			            </div>
			            
			            
			            <hr>
			            <h2 style="text-align: center;">Insert image</h2>
			
			            <div class="hero">
			
			                <label for="input-file" id="drop-area">
			                    <input type="file" accept="image/*" id="input-file" name="FILE" hidden>
			                    <div id="img-view">
			                        <img src="/images/upload.png">
			                        <p>Drag and drop or click here <br>to upload image</p>
			                    </div>
			                </label>     
			
			            </div>
			            <hr>
			            <div class="createListingConfirm">
			                <button class="createListingConfirmBtn" type="submit">Update Listing</button>
			                <button class="createListingConfirmBtn">Cancel</button>
			
			            </div>
			        </div>
			
				</form>
			<% } %>
			
    	</div>
	
	<%@ include file="includes/footer.jsp" %>
	
	<script>
		let priceInput = document.getElementById("priceInput");
		let priceText = document.getElementById("priceText");
		function validatePrice(){
			if (isNaN(priceInput.value)){
				priceInput.style.background = "red";
			} else {
				priceInput.style.background = "#c7c7c7";
			}
		}
		
		let sizeInput = document.getElementById("sizeInput");
		let sizeText = document.getElementById("sizeText");
		function validateSize(){
			if (isNan(sizeInput.value){
				sizeInput.style.background = "red";
			} else {
				sizeInput.style.background = "#c7c7c7";
			}
		}
	</script>
</body>
</html>