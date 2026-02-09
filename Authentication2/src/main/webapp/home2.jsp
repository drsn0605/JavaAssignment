<%@page import="model.User2"%>
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
User2 u = (User2)session.getAttribute("loguser");
if(u==null){
	request.setAttribute("err","Login first..");
	request.getRequestDispatcher("index.jsp").forward(request, response);
}
%>
<h2><b>Welcome, ${msg }</b></h2>
<a href="logout2">Logout</a>
</body>
</html>