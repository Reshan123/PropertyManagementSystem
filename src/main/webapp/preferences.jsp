<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="css/pref.css">
    <link rel="stylesheet" href="css/styleSheet.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <title>Preferences</title>
</head>

<body>
    <%@ include file="includes/header.jsp" %>


    <div class="prefContainder">

        <div class="prefLeftContainer">

            <div class="prefLeft">

                <div class="prefUserInfo">
                    <img src="images/ProfileIcon.png" class="prefLeftImg" alt="user">
                    <h4>User Name</h4>
                </div>

                <div class="otherInfo">
                    <h2>Thanks to Us</h2>
                    <p>ur sorry-ass has another chance to fix your uglyass name</p>
                </div>
            </div>




        </div>

        <div class="prefRightContainer">
            <div class="prefRight">

                <div class="profForm">
                    <h3>Username</h3>
                    <input type="text" class="input" placeholder="username">
                    <h3>Password</h3>
                    <input type="password" class="input" placeholder="password">
                    <h3>Confirm Password</h3>
                    <input type="password" class="input" placeholder="password">
                    <h3>Email</h3>
                    <input type="e-mail" class="input" placeholder="email@example.com">
                </div>

            </div>
            <div class="prefRightBtns">
                <button class="prefRightBtn">Cancel</button>
                <button class="prefRightBtn">Confirm</button>

            </div>
        </div>

    </div>


    <%@ include file="includes/footer.jsp" %>



</body>

</html>