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
<div class="col-6 mx-auto mt-3 p-5 card">
<h2><b><i>Student Registration</i></b></h2>
<hr>
${msg }
<form action="reg12" method="post">
<input type="text" name="name" placeholder="Enter your name" class="form-control">
<br>
<input type="text" name="email" placeholder="Enter your email" class="form-control">
<br>
<input type="text" name="city" placeholder="Enter your city" class="form-control">
<br>
<input type="text" name="country" placeholder="Enter your country" class="form-control">
<br>
<input type="submit" class="btn btn-success">
<input type="reset" class="btn btn-warning">
<a href="display12" class="btn btn-primary">Display</a>

</form>
</div>
</div>
</div>
</body>
</html>