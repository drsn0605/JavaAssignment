<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reg Page</title>

<!-- Bootstrap 5 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container">
    <div class="row">
        <div class="col-md-6 mx-auto mt-5">
            <div class="card shadow p-4">
                <h3 class="text-center mb-4"><b><i>Registration Form</i></b></h3>

				${msg }
                <form action="reg2" method="post">

                    <!-- Username -->
                    <div class="mb-3">
                        <label class="form-label">Username</label>
                        <input type="text" name="name" class="form-control" placeholder="Enter username">
                    </div>

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

                    <!-- Gender -->
                    <div class="mb-3">
                        <label class="form-label d-block">Gender</label>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="male">
                            <label class="form-check-label">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="female">
                            <label class="form-check-label">Female</label>
                        </div>
                    </div>

                    <!-- Language -->
                    <div class="mb-3">
                        <label class="form-label d-block">Language</label>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="lang" value="hin">
                            <label class="form-check-label">Hindi</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="lang" value="guj">
                            <label class="form-check-label">Gujarati</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="lang" value="eng">
                            <label class="form-check-label">English</label>
                        </div>
                    </div>

                    <!-- Country -->
                    <div class="mb-3">
                        <label class="form-label">Country</label>
                        <select name="country" class="form-select">
                            <option value="0">-- Select country --</option>
                            <option value="Bha">Bharat</option>
                            <option value="USA">USA</option>
                            <option value="Aus">Australia</option>
                        </select>
                    </div>

                    <!-- Address -->
                    <div class="mb-3">
                        <label class="form-label">Address</label>
                        <textarea name="address" rows="3" class="form-control"></textarea>
                    </div>

                    <!-- Buttons -->
                    <div>
                        <input type="submit" class="btn btn-primary px-4">
                        <input type="reset" class="btn btn-secondary px-4">
                        </br>
                        </br>
                        <a href="index.jsp" class="text-success">Already have an account, click here</a>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
