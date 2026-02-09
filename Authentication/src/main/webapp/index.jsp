<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card shadow p-4">
                <h3 class="text-center mb-4"><b><i>Login Form</i></b></h3>

				${err }
                <form action="login" method="post">

                    <!-- Email -->
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" placeholder="Enter email">
                    </div>

                    <!-- Password -->
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input type="password" name="pass" class="form-control" placeholder="Enter password">
                    </div>

                    <!-- Buttons -->
                    <div>
                        <input type="submit" class="btn btn-primary" value="Login">
                        <input type="reset" class="btn btn-secondary">
                        <br>
                       <hr>
                        <a href="reg.jsp" class="btn btn-success">New user? Register here</a>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
