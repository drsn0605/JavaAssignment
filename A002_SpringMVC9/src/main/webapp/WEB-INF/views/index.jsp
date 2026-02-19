<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        background: linear-gradient(to right, #eef2f3, #d9e4f5);
        font-family: 'Segoe UI', sans-serif;
    }

    .main-card {
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.08);
        border: none;
    }

    .form-control {
        border-radius: 10px;
        padding: 10px;
    }

    .btn-custom {
        border-radius: 10px;
        padding: 8px 20px;
    }

    .table-card {
        border-radius: 15px;
        box-shadow: 0 6px 18px rgba(0,0,0,0.06);
        border: none;
    }
</style>

</head>
<body>

<div class="container py-5">

    <!-- Heading -->
    <div class="text-center mb-5">
        <h2 class="fw-bold text-primary">Student Management System</h2>
        <p class="text-muted">Add and manage student records easily</p>
    </div>

    <!-- Form Section -->
    <div class="card main-card p-4 mb-5 bg-white">
        <form:form action="addStudent" method="post" modelAttribute="st">

            <form:hidden path="id"/>

            <div class="row g-3 align-items-end">

                <div class="col-md-5">
                    <label class="form-label fw-semibold">Name</label>
                    <form:input path="name" cssClass="form-control"
                        placeholder="Enter student name"/>
                </div>

                <div class="col-md-5">
                    <label class="form-label fw-semibold">Email</label>
                    <form:input path="email" cssClass="form-control"
                        placeholder="Enter student email"/>
                </div>

                <div class="col-md-2">
                    <button type="submit"
                        class="btn btn-primary btn-custom w-100 fw-semibold">
                        Save
                    </button>
                </div>

            </div>

        </form:form>
    </div>

    <!-- Table Section -->
    <div class="card table-card p-4 bg-white">
        <div class="table-responsive">
            <table class="table table-hover align-middle text-center">
                <thead class="table-light">
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
                                   class="btn btn-sm btn-outline-warning btn-custom">
                                   Update
                                </a>
                            </td>
                            <td>
                                <a href="delete?id=${st.id}"
                                   class="btn btn-sm btn-outline-danger btn-custom"
                                   onclick="return confirm('Are you sure you want to delete this student?');">
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
