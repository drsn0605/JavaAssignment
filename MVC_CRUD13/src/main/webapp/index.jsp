<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6 mx-auto mt-3 p-5 card">
<h2><b><i>Student Registration</i></b></h2>
<hr>
${msg }
<form action="reg13" method="post">
<input type="text" name="name" placeholder="Enter your name" class="form-control">
<br>
<input type="text" name="email" placeholder="Enter your email" class="form-control">
<br>
<input type="text" name="state" placeholder="Enter your state" class="form-control">
<br>
<input type="text" name="country" placeholder="Enter your country" class="form-control">
<br>
<input type="submit" class="btn btn-success">
<input type="reset" class="btn btn-primary">
<a href="display13" class="btn btn-warning">Display</a>


</form>
</div>
</div>
</div>
</body>
</html>