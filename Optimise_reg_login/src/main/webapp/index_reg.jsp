<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Construction Management</title>
</head>
<body>

<!-- 
In this file we give two forms one is for NewUser Registration and another one is for login
In the registration form we can get the user's name, Email-id, Password, Mobile-number.
These informations are stored into the database for further operations like login, password updation 
etc..

If the user is already a registered user don't worry we place login page redirection button for
login purpose. 
-->

<!-- Registration Section -->
<h1>Registration</h1>
<form action="register" method="post">

<table>
<tr>
<td> <label for="uname" >Enter your Full Name</label> </td>
<td> <input type="text" name="uname" id="uname" required>       
</tr>

<tr>
<td> <label for="email_id" >Enter your Email-Id</label> </td>
<td> <input type="email" name="email_id" id="email_id" required>
</tr>

<tr>
<td> <label for="password" >Enter your Password</label> </td>
<td> <input type="password" name="password" id="password" required>
</tr>

<tr>
<td> <label for="mobile_number" >Enter your Mobile Number</label> </td>
<td> <input type="number" name="mobile_number" id="mobile_number" required>
</tr>

<tr>
<td></td> 
<td> <input type="submit" value="Register">
</tr>
</table>

</form>   <!-- Registration form ended -->

<!-- Return to Login Section -->
<form action="index_login.jsp" method="post"> <br><br>

<table>
<tr>
<td> Already Have an Account? </td> 
<td><input type="submit" value="Login"></td>
</tr>
</table>

</form>  <!-- Login Section closed -->

</body>
</html>