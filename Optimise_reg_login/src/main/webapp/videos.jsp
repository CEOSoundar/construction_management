<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Videos Here !!</title>
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
      
      <center>
      <iframe width="560" height="315" src="https://www.youtube-nocookie.com/embed/1iO-fSjHY1A" 
      title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write;
      encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
      </center>
</body>
</html>