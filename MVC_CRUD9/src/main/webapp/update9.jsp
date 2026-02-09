<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>

<div class="container">
<div class="row">
<div class="col-5 mx-auto mt-3 p-5 card">
<h2><i><b>Update Student</b></i></h2>
<hr>
	${msg}
	<form action="edit9" method="post">
	<input type="hidden" name="id" value="${sdata.id }">
	<input type="text" name="name" placeholder="Enter Name" class="form-control" value="${sdata.name }">
	<br>
	<input type="text" name="email" placeholder="Enter Email" class="form-control" value="${sdata.email }">
	<br>
	<input type="text" name="village" placeholder="Enter village" class="form-control" value="${sdata.village }">
	<br>
	<input type="submit" class="btn btn-success">
	<input type="reset" class="btn btn-warning">
	<a href="display9" class="btn btn-danger">Display</a>
	</form>
	
</div>
</div>
</div>
</body>
</html>