<%@page import="model.Student11"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6 mx-auto mt-3 p-5 card">
<h2><i><b>Student Details</b></i></h2>
<hr>

<table class="table">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Institute</th>
		<th>Action</th>
	</tr>
	
<%
ArrayList<Student11> al = (ArrayList)request.getAttribute("data11");
for(Student11 st : al){
%>
	<tr> 
		<td><%= st.getId() %></td>
		<td><%= st.getName() %></td>
		<td><%= st.getEmail() %></td>
		<td><%= st.getInstitute() %></td>
		<td><a href="delete11?stid=<%= st.getId() %>" class="btn btn-danger">Delete</a></td>
	</tr>
<%
}
%>
</table>
<a href="index.jsp" class="btn btn-success">Back to Registration page</a>
</div>
</div>
</div>
</body>
</html>