<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update2</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
<div class="col-5 mx-auto mt-3 p-4 card">
<!-- <div class="bg-info text-white p-3"> -->
<h2><i>Update Student</i></h2>
<hr>
${msg2 }
<form action="edit2" method="post">

<input type="hidden" name="nid" value="${std02.id }">
<input type="text" name="name"  placeholder="enter name" class="form-control" value="${std02.name }">
<br>
<input type="text" name="email" placeholder="enter email" class="form-control" value="${std02.email }">
<br>
<input type="text" name="age" placeholder="enter age" class="form-control" value="${std02.age }">
<br>
<input type="submit" class="btn btn-success">
<input type="reset" class="btn btn-primary">

<a href="display" class="btn btn-warning">Display</a>
</form>
</div>
</div>
</div>
</div>
</body>
</html>