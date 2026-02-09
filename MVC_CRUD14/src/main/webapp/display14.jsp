<%@page import="model.Student14"%>
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
<div class="col-8 mx-auto mt-3 p-5 card">
<table class="table">
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Email</th>
	<th>State</th>
	<th>Country</th>
	<th colspan=2>Action</th>
</tr>

<% 
ArrayList<Student14> al = (ArrayList)request.getAttribute("stdata");
for(Student14 st : al){
%>

<tr>
	<td><%=st.getId() %></td>
	<td><%=st.getName() %></td>
	<td><%=st.getEmail() %></td>
	<td><%=st.getState() %></td>
	<td><%=st.getCountry() %></td>
	<td><a href="delete14?stid=<%=st.getId() %>" class="btn btn-danger">Delete</a></td>
	<td><a href="edit14?eid=<%=st.getId() %>" class="btn btn-secondary">Update</a></td>
</tr>
<%
}
%>

</table>
<a href="index.jsp" class="btn btn-success">Back to Regitration page</a> 
</div>
</div>
</div>
</body>
</html>