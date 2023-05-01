<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Password</title>

<style>
      .label 
      {
        display: inline-block;
        width: 200px;
      }
      .form-group 
      {
        margin-bottom: 1rem;
      }
      #confirmPassword-feedback 
      {
        color: red;
      }
</style>

</head>
<body>

<h1> Set New Password here</h1>

<!--  
<form action="new_password_compare" method="post" id="pass_form">
<table>
<tr>
<td> <label for="new_password" > Enter your new  Password</label> </td>
<td> <input type="text" name="new_password" id="new_password" required>
</tr>

<tr>
<td> <label for="retype_password" ></label> Retype your Password </td>
<td> <input type="text" name="retype_password" id="retype_password" required>
</tr>

<tr>
<td> </td>
<td> <input type="submit" value="Change Password" required> </td>
</tr>
</table>
</form>  -->

<form action="new_password_change" id="myForm" method="POST">

      <div class="form-group">
        <label class="label">Password: </label>
        <input type="password" name="new_password" required />
      </div>
      
      <div class="form-group">
        <label class="label">Confirm Password: </label>
        <input type="password" name="retype_password" required />
        <br>
        <small id="confirmPassword-feedback"></small>
      </div>
      
      <div><input type="submit" value="Submit" /></div>
      
</form>
    
<script>
      const form = document.getElementById("myForm");
      const password = form.new_password;
      const confirmPassword = form.retype_password;
      const feedback = document.getElementById("confirmPassword-feedback");
      let isPasswordMatch = false;

      confirmPassword.addEventListener("input", () => 
      {
        if (password.value != confirmPassword.value) 
        {
          feedback.innerHTML = "Password did not match.";
          isPasswordMatch = false;
        } 
        else 
        {
          feedback.innerHTML = "Password match.";
          isPasswordMatch = true;
        }
      });

      form.onsubmit = function () {
        if (isPasswordMatch) {
          alert("Please click 'ok' to change the password");
          return true;
        }
        alert("Wait! Password did not match.");
        return false;
      };
</script>


</body>
</html>