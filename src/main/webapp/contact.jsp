<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="css/contact.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/styleSheet.css">

    <title>Contact</title>
</head>

<body>

    <%@ include file="includes/header.jsp" %>



    <section class="contact">
        <div class="container contact_container">
            <aside class="contact_aside">
                <div class="aside_image">
                    <img src="images\contact.png">
                </div>
                <h1>Contact Us</h1>
                <p>
                <h5>At (name), we are committed to providing exceptional property
                    management services and ensuring that our clients' needs are met with the utmost professionalism and
                    care. <br>We value your inquiries, feedback, and questions, and we're here to assist you in any way we
                    can.</h5>
                </p>
                <ul class="contact_details">
                    <li>
                        <i class="uil-phone-times"></i>
                        <h5>pnum</h5>
                    </li>
                    <li>
                        <i class="uil uil-envelope"></i>
                        <h5>email@gmail.com</h5>
                    </li>
                    <li>
                        <i class="uil-location-point"></i>
                        <h5>location</h5>
                    </li>
                </ul>
            </aside>

            <!-- <h1>Send us Feedback</h1> -->
            <div class="contactRight">
                <h1>Send us your Feedback </h1>

                <form action="#" method="POST" class="contact_form">
                    <div class="from_name">
                        <input type="text" name="fName" id="fName" placeholder="First Name" required>
                        <input type="text" name="lName" id="lName" placeholder="Last Name" required>
                    </div>
                    <input type="email" name="Email address" placeholder="Your Eamil Adress" required>
                    <input type="text" name="message" id="message" placeholder="Message" required></textarea>
                    <button type="submit" name="send" id="name " class="btn btn-primary">Send Massage</button>
                </form>

            </div>



        </div>
    </section>


    <%@ include file="includes/footer.jsp" %>



</body>

</html>