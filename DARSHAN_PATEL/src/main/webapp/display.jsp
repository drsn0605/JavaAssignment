<%@page import="model.Student01"%>
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
<div class="col-8 mx-auto mt-3 p-5 card">
<h2><b><i>Student Information</i></b></h2>
<hr>
<table class="table">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Course</th>
		<th>age</th>
		<th>createdAt</th>
		<th colspan="2">Action</th>
	</tr>
	
<%
ArrayList<Student01> al = (ArrayList)request.getAttribute("data01");
for(Student01 st : al){
%>

	<tr>
		<td> <%= st.getId() %></td>
		<td> <%= st.getName() %></td>
		<td> <%= st.getEmail() %></td>
		<td> <%= st.getCourse() %></td>
		<td> <%= st.getAge() %></td>
		<td> <%= st.getCreatedAt() %></td>
		
		
		<td><a href="delete?stid=<%=st.getId() %>" class="btn btn-warning">Delete</a></td>
		<td><a href="edit?eid=<%=st.getId() %>" class="btn btn-danger">Update</a></td>
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