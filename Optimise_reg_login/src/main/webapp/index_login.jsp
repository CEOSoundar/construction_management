<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Construction Management</title>
</head>
<body>

<!-- IN this we can get user registered email-id and password to allow  the user to use the web application
In case if the user is not a registered user then it will show respective error message's that please check 
the email-id and password.
If the user entered correct user name and password then it will allow the user to use the application.
-->

<!-- Login Section -->
<h1>User Login</h1>
<form action="login" method="post">

<table>
<tr>
<td> <label for="email_id">Enter your Email-id</label> </td>
<td> <input type="email" name="email_id" id="email_id" required>
</tr>

<tr>
<td> <label for="password">Enter your Password</label> </td>
<td> <input type="password" name="password" id="password" required>
</tr>

<tr>
<td></td>
<td> <input type="submit" value="Login"> </td>
</tr>
</table>

<a href="forgot_pass.jsp" >Forgot Password ?</a>  <!-- Forget Password section -->

</form>  <!-- Login form closed -->

<!-- Return to Register Section -->
<form action="index_reg.jsp" method="post"> <br><br>

<table>
<tr>
<td> Don't have an account? </td> 
<td><input type="submit" value="Create Account"></td>
</tr>
</table>

</form> <!-- Register form section closed -->

</body>
</html>