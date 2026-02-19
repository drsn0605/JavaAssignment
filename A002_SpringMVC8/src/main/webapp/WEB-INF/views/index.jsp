<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>

<!-- Bootstrap 5 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">

    <!-- Heading -->
    <div class="text-center mb-4">
        <h2 class="fw-bold text-primary">Student Details</h2>
    </div>

    <!-- Form Card -->
    <div class="card shadow mb-5">
        <div class="card-body">

            <form:form action="addStudent" method="post" modelAttribute="st">

                <form:hidden path="id"/>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Name</label>
                    <form:input path="name" cssClass="form-control" placeholder="Enter student name"/>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Email</label>
                    <form:input path="email" cssClass="form-control" placeholder="Enter student email"/>
                </div>

                <div class="text-end">
                    <button type="submit" class="btn btn-primary px-4">
                        Save
                    </button>
                </div>

            </form:form>

        </div>
    </div>

    <!-- Table Card -->
    <div class="card shadow">
        <div class="card-body">

            <div class="table-responsive">
                <table class="table table-bordered table-hover align-middle">
                    <thead class="table-dark text-center">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>

                    <tbody class="text-center">
                        <c:forEach items="${students}" var="st">
                            <tr>
                                <td>${st.id}</td>
                                <td>${st.name}</td>
                                <td>${st.email}</td>
                                <td>
                                    <a href="update?id=${st.id}" 
                                       class="btn btn-sm btn-warning">
                                       Update
                                    </a>
                                </td>
                                <td>
                                    <a href="delete?id=${st.id}" 
                                       class="btn btn-sm btn-danger"
                                       onclick="return confirm('Are you sure you want to delete?');">
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

</div>

</body>
</html>