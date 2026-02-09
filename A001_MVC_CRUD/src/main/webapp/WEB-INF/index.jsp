<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page 6 </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>

<div class="container">
<div class="row">
<div class="col-5 mx-auto mt-3 p-5 card">
<h2><b><i>Student Registration</i></b></h2>
<hr>


${msg }
<form action="reg6" method="post">
<input type="text" name="name" placeholder="enter name" class="form-control" >
<br>
<input type="text" name="email" placeholder="enter email" class="form-control">
<br>
<input type="text" name="course" placeholder="Enter your course" class="form-control">
<br>
<input type="text" name="age" placeholder="Enter your age" class="form-control">
<br>
<input type="text" name="createdAt" class="form-control">
<br>
<input type="submit" class="btn btn-success">
<input type="reset" class="btn btn-warning">
<a href="display6" class="btn btn-danger">Display</a>
</form>

</div>
</div>
</div>
</body>
</html>