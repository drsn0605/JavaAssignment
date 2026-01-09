<%@page import="model.Student7"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="col-7 mx-auto mt-3 p-5 card">
<h2><i><u>Student Information</u></i></h2>
<hr>
<table class="table">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Country</th>
		<th colspan="2">Action</th>
	</tr>
<% 
ArrayList<Student7> al = (ArrayList)request.getAttribute("data7");
for(Student7 st : al){
%>

	<tr> 
		<td><%= st.getId() %></td>
		<td><%= st.getName() %></td>
		<td><%= st.getEmail() %></td>
		<td><%= st.getCountry() %></td>
		<td><a href="delete7?stid=<%= st.getId() %>" class="btn btn-danger" >Delete</a></td>
		<td><a href="edit7?eid=<%= st.getId() %>" class="btn btn-secondary">Update</a></td>
	</tr>
<%
}
%>
</table>
<a href="index.jsp" class="btn btn-warning">Back to home page</a>
</div>
</div>
</div>
</body>
</html>