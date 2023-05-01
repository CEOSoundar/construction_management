<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

      <%
      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  //HTTP 1.1
      response.setHeader("pragma", "no-cache");  //HTTP 1.0
      response.setHeader("Expires", "0");  //proxies
   
      if(session.getAttribute("email_id") == null)
      {
    	  response.sendRedirect("index_login.jsp");
      }
      %>
      
      Welcome ${username}
      
      <a href="videos.jsp">Videos here</a>
      
      <form action="logout">
      <input type="submit" value="Logout">
      </form>
      
</body>
</html>