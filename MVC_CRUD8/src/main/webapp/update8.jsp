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
<div class="col-5 mx-auto mt-3 p-5 card">
<h2><b><i>Update Student</i></b></h2>
<hr>
${msg }
<form action="edit8" method="post">
<input type="hidden" name="id7" value="${stdata.id }">
<input type="text" name="name" placeholder="enter name" class="form-control" value="${stdata.name }">
<br>
<input type="text" name="email" placeholder="enter email" class="form-control" value="${stdata.email }">
<br>
<input type="text" name="state" placeholder="enter state" class="form-control" value="${stdata.state }">
<br>
<input type="submit" class="btn btn-success">
<input type="reset" class="btn btn-primary">
<a href="display8" class="btn btn-warning">Display</a>

</form>
</div>
</div>
</div>
</body>
</html>