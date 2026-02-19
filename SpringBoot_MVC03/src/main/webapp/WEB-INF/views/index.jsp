<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<form:form action="addProduct" method="post" modelAttribute="product">
	<form:hidden path="id"/>
	<form:label path="name">Name</form:label>
	<form:input path="name"/>
	<form:label path="price">Price</form:label>
	<form:input path="price"/>
	<form:label path="qty">Qty</form:label>
	<form:input path="qty"/>
	<input type="submit">
</form:form>
<br>
<h2><b>Product Details</b></h2>
<table border="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Qty</th>
		<th colspan="2">Action</th>
	</tr>
	
	<c:forEach items="${products }" var="prod">
	<tr>
		<td>${prod.id }</td>
		<td>${prod.name }</td>
		<td>${prod.price }</td>
		<td>${prod.qty }</td>
		<td><a href="delete?id=${prod.id }">Delete</a></td>
		<td><a href="update?id=${prod.id }">Update</a></td>
	</tr>
	</c:forEach>

</table>
</body>
</html>