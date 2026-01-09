<%@page import="model.Student12"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
<div class="col-7 mx-auto mt-3 p-4 card">
<h2><b><i>Student Details</i></b></h2>
<hr>
<table class="table">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>City</th>
		<th>Country</th>
		<th>Action</th>
	</tr>
<%
ArrayList<Student12> al = (ArrayList)request.getAttribute("data12");
for(Student12 st : al){
%>
	<tr> 
		<td><%= st.getId() %></td>
		<td><%= st.getName() %></td>
		<td><%= st.getEmail() %></td>
		<td><%= st.getCity() %></td>
		<td><%= st.getCountry() %></td>
		<td><a href="delete12?stid=<%=st.getId()%>" class="btn btn-danger">Delete</a></td>
	</tr>
<%
}
%>
</table>
<a href="index.jsp" class="btn btn-primary">Back to registration page</a>
</div>
</div>
</div>
</body>
</html>