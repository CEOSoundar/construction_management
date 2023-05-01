<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
</head>
<body>

<!-- This form section is for entering the email-id for password reset -->

<form action="VerifyEmailAndSendOTPMail" method="post">    <!-- verify email and get OTP section -->
<label for="forgot_emailid" >Enter your Email-Id</label> 
<input type="email" name="forgot_emailid" id="forgot_emailid" required> 

<input type="submit" value="Get OTP"> 
</form>

<br><br>

<form action="entered_user_otp" method = "post">    <!-- enter OTP section -->
<label for="entered_otp" >Enter OTP</label> 
<input type="text" name="entered_otp" id="entered_otp" required> 
<input type="submit" value="Submit"> 
</form>

</body>
</html>