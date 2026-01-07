<%@page import="model.Student6"%>
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
<h2><b><i>Student Information</i></b></h2>
<hr>
<table class="table">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Action</th>
	</tr>
	
<%
ArrayList<Student6> al = (ArrayList)request.getAttribute("data6");
for( Student6 st : al){
%>

	<tr>
		<td> <%= st.getId() %></td>
		<td> <%= st.getName() %></td>
		<td> <%= st.getEmail() %></td>
		<td> <%= st.getPhone() %></td>
		<td><a href="delete6?stid=<%= st.getId() %>" class="btn btn-warning">Delete</a></td>
	</tr>
<%
}
%>

</table>
<a href="index.jsp" class="btn btn-success"> back to registration page</a>	
</div>
</div>
</div>
</body>
</html>