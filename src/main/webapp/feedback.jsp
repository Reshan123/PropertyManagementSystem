<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page 
	import="com.PropertyManagementSystem.ContactDetails"
	import="com.PropertyManagementSystem.FeedbackDetails"	
 %>

<%
	User userProfile = (User) session.getAttribute("user");
	FeedbackDetails feedback =  (FeedbackDetails) request.getAttribute("feedback");
	
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="css/feedback.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/styleSheet.css">

    <title>Feedback</title>
</head>

<body>

    <%@ include file="includes/header.jsp" %>



    <section class="contact">
    
    	<div class="contact_container">
            <aside class="contact_aside">
                <div class="aside_image">
                    <img src="images\feedback.png">
                </div>
                
            </aside>

            <!-- <h1>Send us Feedback</h1> -->
            <%	if (userProfile == null){ %>
				<div class="contactRight" >
	                <h1>Send us your Feedback </h1>
	
	                <form action="Feedback" method="POST" class="contact_form">
	                    <div class="from_name">
	                        <input type="text" id="fname" onChange="fnameValidate()" name="fName" placeholder="First Name" required style="color:white;">
	                        <input type="text" id="lname" onChange="lnameValidate()" name="lName" placeholder="Last Name" required style="color:white;">
	                    </div>
	                    <input type="email" name="Email" placeholder="Your Eamil Adress" required style="color:white;">
	                    <textarea rows="5" cols="10" name="message" id="message" placeholder="Message" required style="color:white;"></textarea>
	                    <button type="submit" name="send" id="name " class="btn btn-primary" onClick="alert('Feedback Sent')">Send Message</button>
	                </form>
	
	            </div>
	        <% } else if (userProfile != null && feedback == null) { %>
	       		<div class="contactRight" >
	                <h1>Send us your Feedback </h1>
	
	                <form action="Feedback" method="POST" class="contact_form">
	                    <div class="from_name">
	                        <input type="text" id="fname" onChange="fnameValidate()" name="fName" id="fName" placeholder="First Name" required style="color:white;" >
	                        <input type="text" id="lname" onChange="lnameValidate()" name="lName" id="lName" placeholder="Last Name" required style="color:white;">
	                    </div>
	                    <input type="email" name="Email" placeholder="Your Eamil Adress" required style="color:white;" >
	                    <textarea rows="5" cols="10" name="message" id="message" placeholder="Message" required style="color:white;"></textarea>
	                    <input type="text" name="UID" required style="display:none;" value="<%= userProfile.getUID() %>">
	                    <button type="submit" name="send" id="name " class="btn btn-primary" onClick="alert('Feedback Submitted')">Send Massage</button>
	                </form>       
	            </div>
	        <% } else if (userProfile != null && feedback != null) { %>
	        	<div class="contactRight" >
	                <h1>Send us your Feedback </h1>
	
	                <form action="FeedbackEdit" method="POST" class="contact_form">
	                    <div class="from_name">
	                        <input type="text" id="fname" onChange="fnameValidate()" name="fName" id="fName" placeholder="First Name" required style="color:white;" value="<%= feedback.getFname() %>">
	                        <input type="text" id="lname" onChange="lnameValidate()" name="lName" id="lName" placeholder="Last Name" required style="color:white;" value="<%= feedback.getLname() %>">
	                    </div>
	                    <input type="email" name="Email" placeholder="Your Eamil Adress" required style="color:white;" value="<%= feedback.getEmail() %>">
	                    <textarea rows="5" cols="10" name="message" id="message" placeholder="Message" required style="color:white;"><%= feedback.getMessage() %></textarea>
	                    <input type="text" name="UID" required style="display:none;" value="<%= feedback.getUID() %>">
	                    <div style="display:flex">
	                    	<button type="submit" name="send" id="name " class="btn btn-primary" onClick="alert('Feedback Updated')">Send Massage</button>
							<div class="btn btn-primary" onClick="window.location.href='DeleteFeedback?UserID=<%= user.getUID() %>'" >DELETE</div>
	                    </div>
	                </form>	          
				
	
	            </div>
			<% } %>

        </div>
    </section>


    <%@ include file="includes/footer.jsp" %>
    
    <script>
		let fname = document.getElementById("fname");
		function fnameValidate(){
			if (isNaN(fname.value)){
				fname.style.background = "#4e4e4e";
			} else {
				fname.style.background = "red";
			}
		}
		
		let lname = document.getElementById("lname");
		function lnameValidate(){
			if (isNan(lname.value)){
				lname.style.background = "#4e4e4e";
			} else {
				lname.style.background = "red";
			}
		}
	</script>



</body>

</html>