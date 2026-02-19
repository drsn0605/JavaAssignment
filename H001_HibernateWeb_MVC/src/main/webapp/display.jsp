<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
<div class="col-8 mx-auto mt-3 p-5 card">
<h2>Student details</h2>
<hr>
<table class="table">

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th colspan="2">Action</th>
   <!-- dlt - 1st -->
</tr>
<%
//12th 
ArrayList<Student> al = (ArrayList)request.getAttribute("data");
for(Student st : al)
{
%>

	<tr>
	<td><%= st.getId() %></td>   <!-- here = is use for printing data -->
	<td><%= st.getName() %></td>
	<td><%= st.getEmail() %></td>
	<td><%= st.getPhone() %></td>
	
	<!-- dlt - 2nd -->
	<td><a href="delete?sid=<%= st.getId() %>" class="btn btn-danger">Delete</a></td>     <!-- through delete - hum delete nam ke servlet pe jayenge , fir vapas ham display pe aa jayende -->
	<td><a href="edit?eid=<%= st.getId() %>" class="btn btn-primary">Update</a></td>
	</tr>	
	
<% 	
} %>

</table>

<a href="index.jsp" class="btn btn-success">Back to Regitration page</a>  <!-- 13th -->

</div>
</div>
</div>
</body>
</html>