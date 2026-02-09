<%@page import="model.User4"%>
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
User4 u = (User4)session.getAttribute("userAttr");
if(u==null){
	request.setAttribute("err","Please login first!!");
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
%>
<h2><b>Welcome, ${msg }</b></h2>
<a href="logout">Logout</a>
</body>
</html>