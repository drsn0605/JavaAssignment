<%@page import="model.Student5"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>

<div class="container">
<div class="row">
<div class="col-7 mx-auto mt-3 p-6 card">
<h2><b><i>Student Details</i></b></h2>
<hr>

<table class="table">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>City</th>
		<th colspan="2">Action</th>
	</tr>

<%
ArrayList<Student5> al = (ArrayList)request.getAttribute("data5");
for(Student5 st : al){
%>

	<tr> 
		<td><%= st.getId() %></td>
		<td><%= st.getName() %></td>
		<td><%= st.getEmail() %></td>
		<td><%= st.getCity() %></td>
		<td><a href="delete5?stid=<%=st.getId() %>" class="btn btn-danger">Delete</a></td>
		<td><a href="edit5?eid=<%=st.getId() %>" class="btn btn-primary">Update</a></td>
	</tr>
<%
}
%>
</table>
<a href="index.jsp" class="btn btn-warning">Back to registration page</a>

</div>
</div>
</div>
</body>
</html>