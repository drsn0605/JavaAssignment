
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
<div class="col-5 mx-auto mt-3 p-5 card">
<h2><i><b>Registration Page</b></i></h2>
<hr>
${msg }
<form action="reg11" method="post">
<input type="text" name="name" placeholder="Enter your name" class="form-control">
<br>
<input type="text" name="email" placeholder="Enter your email" class="form-control">
<br>
<input type="text" name="institute" placeholder="Enter your institute" class="form-control">
<br>
<input type="submit" class="btn btn-success">
<input type="reset" class="btn btn-warning">
<a href="display11" class="btn btn-danger">Display</a>

</form>

</div>
</div>
</div>
</body>
</html>