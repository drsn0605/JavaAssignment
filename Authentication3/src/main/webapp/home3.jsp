<%@page import="model.User3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
<%
User3 u = (User3)session.getAttribute("duser");
if(u==null){
	
	request.setAttribute("err", "Please Login First!!");
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
%>
<h2>Welcome, ${msg }</h2>
<a href="logout3">Logout</a>
</body>
</html>