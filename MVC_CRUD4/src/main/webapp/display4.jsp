<%@page import="model.Student4"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
<div class="col-7 mx-auto mt-5 p-5 card">
<h3><i>Student Display Panel</i></h3>
<hr>
<table class="table">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Hometown</th>
		<th colspan="2">Action</th>
	</tr>
<%
ArrayList<Student4> al = (ArrayList)request.getAttribute("datta");
for(Student4 st : al){
%>
<tr>
	<td><%= st.getId() %></td>
	<td><%= st.getName() %></td>
	<td><%= st.getEmail() %></td>
	<td><%= st.getHometown() %></td>
	<td><a href="delete4?stid=<%= st.getId() %>" class="btn btn-warning">Delete</a></td>
	<td><a href="edit4?eid=<%= st.getId() %>" class="btn btn-secondary" >Update</a></td>
</tr>
<% 
} %>
</table>
<a href="index.jsp" class="btn btn-success">Back to registration page</a>
</div>
</div>
</div>
</body>
</html>