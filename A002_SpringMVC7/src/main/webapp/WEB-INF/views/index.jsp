<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>

<!-- Bootstrap 5 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #121212;
        color: #ffffff;
    }

    .card {
        background-color: #1e1e1e;
        border: none;
        border-radius: 15px;
    }

    /* Labels */
    .form-label {
        color: #ffffff;
        font-weight: 500;
    }

    /* Input fields */
    .form-control {
        background-color: #2c2c2c;
        border: 1px solid #555;
        color: #ffffff;
    }

    /* Placeholder color */
    .form-control::placeholder {
        color: #bbbbbb;
        opacity: 1;
    }

    .form-control:focus {
        background-color: #2c2c2c;
        color: #ffffff;
        border-color: #0dcaf0;
        box-shadow: 0 0 5px rgba(13, 202, 240, 0.5);
    }

    .table {
        color: #ffffff;
    }

    .table thead {
        background-color: #0d6efd;
    }
</style>


</head>
<body>

<div class="container mt-5">

    <!-- Heading -->
    <div class="text-center mb-4">
        <h2 class="fw-bold text-info">Student Management System</h2>
        <p class="text-secondary">Add and Manage Student Records</p>
    </div>

    <!-- Form Section -->
    <div class="card shadow p-4 mb-5">
        <form:form action="addStudent" method="post" modelAttribute="st">
			<form:hidden path="id"/>
            <div class="row">
                <div class="col-md-5 mb-3">
                    <label class="form-label">Name</label>
                    <form:input path="name" cssClass="form-control" placeholder="Enter student name"/>
                </div>

                <div class="col-md-5 mb-3">
                    <label class="form-label">Email</label>
                    <form:input path="email" cssClass="form-control" placeholder="Enter student email"/>
                </div>

                <div class="col-md-2 d-flex align-items-end mb-3">
                    <button type="submit" class="btn btn-info w-100 fw-semibold">
                        Save
                    </button>
                </div>
            </div>

        </form:form>
    </div>

    <!-- Table Section -->
    <div class="card shadow p-4">
        <div class="table-responsive">
            <table class="table table-dark table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${students}" var="st">
                        <tr>
                            <td>${st.id}</td>
                            <td>${st.name}</td>
                            <td>${st.email}</td>
                            <td>
                                <a href="update?id=${st.id}" 
                                   class="btn btn-sm btn-warning fw-semibold">
                                   Update
                                </a>
                            </td>
                            <td>
                                <a href="delete?id=${st.id}" 
                                   class="btn btn-sm btn-danger fw-semibold"
                                   onclick="return confirm('Are you sure you want to delete this student ?');">
                                   Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
