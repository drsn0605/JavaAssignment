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
<div class="col-5 mx-auto mt-5 p-5 card">
<h3><i>Update Student</i></h3>
${msg2 }
<form action="edit4" method="post">
<input type="hidden" name="id" value="${stdata.id }" class="form-control">
<input type="text" name="name" placeholder="enter name" class="form-control" value="${stdata.name }">
<br>
<input type="text" name="email" placeholder="enter email" class="form-control" value="${stdata.email }">
<br>
<input type="text" name="hometown" placeholder="enter hometown" class="form-control" value="${stdata.hometown }">
<br>
<input type="submit" class="btn btn-success">
<input type="reset" class="btn btn-primary">
<a href="display4" class="btn btn-warning">Display</a>
</form>
</div>
</div>
</div>
</body>
</html>