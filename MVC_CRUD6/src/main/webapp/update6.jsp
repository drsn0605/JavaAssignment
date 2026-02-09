<%@page import="model.Student6"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>

<div class="container">
<div class="row">
<div class="col-5 mx-auto mt-3 p-5 card">
<h2><b><i>Update Student</i></b></h2>
<hr>
${msg2 }
<form action="edit6" method="post">
<input type="hidden" name="newid" value="${stdata6.id }">
<input type="text" name="name" placeholder="enter name" class="form-control" value="${stdata6.name }">
<br>
<input type="text" name="email" placeholder="enter email" class="form-control" value="${stdata6.email }">
<br>
<input type="text" name="city" placeholder="enter city" class="form-control" value="${stdata6.city }">
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