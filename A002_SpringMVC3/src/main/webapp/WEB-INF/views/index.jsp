<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addStudent" method="post" modelAttribute="st">
		<form:hidden path="id"/>
		<form:label path="name">Name</form:label>
		<form:input path="name"/>
		<form:label path="email">Email</form:label>
		<form:input path="email"/>
		<input type="submit">
	</form:form>
	
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th colspan="2">Action</th>
			</tr>
			
			<c:forEach items="${students}" var="st">
			<tr>
				<td>${st.id }</td>
				<td>${st.name }</td>
				<td>${st.email }</td>
				<td><a href="update?id=${st.id }">Update</a></td>
				<td><a href="delete?id=${st.id }">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	
</body>
</html>