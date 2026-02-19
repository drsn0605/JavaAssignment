<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management</title>

<!-- Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(to right, #eef2f7, #f8fbff);
        font-family: 'Segoe UI', sans-serif;
    }

    .card {
        border: none;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.08);
    }

    .form-control {
        border-radius: 10px;
        padding: 10px;
    }

    .btn-custom {
        border-radius: 8px;
        padding: 6px 15px;
    }

    .table thead {
        background-color: #0d6efd;
        color: white;
    }

    .table tbody tr:hover {
        background-color: #f2f6ff;
        transition: 0.2s;
    }
</style>

</head>
<body>

<div class="container py-5">

    <!-- Heading -->
    <div class="text-center mb-5">
        <h2 class="fw-bold text-primary">Product Management System</h2>
        <p class="text-muted">Manage your product inventory efficiently</p>
    </div>

    <!-- Form Card -->
    <div class="card p-4 mb-5 bg-white">
        <form:form action="addProduct" method="post" modelAttribute="pro">

            <form:hidden path="id"/>

            <div class="row g-3 align-items-end">

                <div class="col-md-4">
                    <label class="form-label fw-semibold">Product Name</label>
                    <form:input path="name"
                        cssClass="form-control"
                        placeholder="Enter product name"/>
                </div>

                <div class="col-md-3">
                    <label class="form-label fw-semibold">Price</label>
                    <form:input path="price"
                        cssClass="form-control"
                        placeholder="Enter price"/>
                </div>

                <div class="col-md-3">
                    <label class="form-label fw-semibold">Quantity</label>
                    <form:input path="qty"
                        cssClass="form-control"
                        placeholder="Enter quantity"/>
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

    <!-- Table Card -->
    <div class="card p-4 bg-white">
        <div class="table-responsive">
            <table class="table table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Qty</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${products}" var="prod">
                        <tr>
                            <td>${prod.id}</td>
                            <td>${prod.name}</td>
                            <td>₹ ${prod.price}</td>
                            <td>${prod.qty}</td>
                            <td>
                                <a href="update?id=${prod.id}"
                                   class="btn btn-sm btn-outline-warning btn-custom">
                                   Update
                                </a>
                            </td>
                            <td>
                                <a href="delete?id=${prod.id}"
                                   class="btn btn-sm btn-outline-danger btn-custom"
                                   onclick="return confirm('Are you sure?');">
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
