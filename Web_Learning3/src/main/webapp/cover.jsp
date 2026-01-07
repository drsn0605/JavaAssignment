<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${message}
	<form action="cover" method="get">
		<input type="text" name="nickname" placeholder="enter your nick name">
		<input type="text" name="city" placeholder="enter your city">
		<input type="text" name="sport" placeholder="enter your sport">
		<input type="text" name="age" placeholder="enter your age"> 
		<input type="submit">
	</form>

</body>
</html>