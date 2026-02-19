<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addProduct" method="post" modelAttribute="product">
		<form:label path="name">Name</form:label>
		<form:input path="name"/>
		<form:label path="price">price</form:label>
		<form:input path="price"/>
		<form:label path="qty">Qty</form:label>
		<form:input path="qty"/>
		<input type="submit">
	</form:form>
	
	<br>
	<h1>Product List</h1>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Qty</th>
			<th colspan="2">Action</th>
		</tr>
		
		<c:forEach var="pro" items="${products}">
			 <tr>
			 	<td>${pro.getId()}</td>
			 	<td>${pro.getName()}</td>
			 	<td>${pro.getPrice()}</td>
			 	<td>${pro.getQty()}</td>
			 	
			 </tr>
		</c:forEach>
	</table>
</body>
</html>