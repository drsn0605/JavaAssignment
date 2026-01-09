<%@page import="model.Student2"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6 mx-auto mt-3 p-4 card">
<!-- <div class="bg-info text-white p-3"> -->
<h2><i>Student Details</i></h2>
<hr>

<table class="table">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Age</th>
		<th colspan="2">Action</th>
	</tr>
<%  
ArrayList<Student2> al = (ArrayList)request.getAttribute("data");
for(Student2 st : al){ %>

	<tr>
		<td><%= st.getId() %></td>
		<td><%= st.getName() %></td>
		<td><%= st.getEmail() %></td>
		<td><%= st.getAge() %></td>
		<td><a href="delete?stid=<%=st.getId()%>" class="btn btn-danger">Delete</a></td>
		<td><a href="edit2?eid=<%= st.getId()%>" class="btn btn-warning">Update</a></td>
	</tr>
	
<% 
} %>
</table>

<a href="index.jsp" class="btn btn-primary">Back to Registration page</a>
</div>
</div>
</div>

</body>
</html>