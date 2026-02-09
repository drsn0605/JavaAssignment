<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">	

<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card shadow p-4">
                <h3 class="text-center mb-4"><b><i>Registration Form</i></b></h3>
                
			    ${msg4 }
                <form action="reg4" method="post">

                    <!-- Username -->
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" name="name" class="form-control" placeholder="Enter your name">
                    </div>
                    
                    <!-- surname -->
                     <div class="mb-3">
                        <label class="form-label">Surname</label>
                        <input type="text" name="surname" class="form-control" placeholder="Enter your surname">
                    </div>

                    <!-- Email -->
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" placeholder="Enter your email">
                    </div>

                    <!-- Password -->
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input type="password" name="pass" class="form-control" placeholder="Enter password">
                    </div>

                   

                    <!-- Language -->
                    <div class="mb-3">
                        <label class="form-label">Language</label><br>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="lang" value="guj">
                            <label class="form-check-label">Gujarati</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="lang" value="hin">
                            <label class="form-check-label">Hindi</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="lang" value="eng">
                            <label class="form-check-label">English</label>
                        </div>
                    </div>

       

                    <!-- Buttons -->
                    <div>
                        <input type="submit" class="btn btn-primary">
                        <input type="reset" class="btn btn-secondary">
                        <br>
                        <hr>
                        <a href="index.jsp" class="text-success">Already have an account? Login here</a>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
