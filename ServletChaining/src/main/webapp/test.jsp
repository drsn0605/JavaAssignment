<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CheckTest</title>
</head>
<body>
<h2>Welcome Page</h2>

    <%
        // Get data from request
        String name = (String) request.getAttribute("name");
    %>

    <p>Hello, <b><%= name %></b></p>
</body>
</html>