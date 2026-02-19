<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6 mx-auto mt-3 p-5 card">
<!-- <div class="bg-warning text-white p-3"> -->
<h2><i><b><u>Update Student</u></b></i></h2>
<hr>
${msg2 }
<form action="edit3" method="post">
<input type="hidden" name="ID" value="${std03.id }">
<input type="text" name="name" placeholder="enter name" class="form-control" value="${std03.name }">
<br>
<input type="text" name="email" placeholder="enter email" class="form-control" value="${std03.email }">
<br>
<input type="text" name="num" placeholder="enter number" class="form-control" value="${std03.num }">
<br>
<input type="submit" class="btn btn-success">
<input type="reset" class="btn btn-primary">
<a href="display3" class="btn btn-danger">Display</a>
</form>
</div>
</div>
</div>
</body>
</html>