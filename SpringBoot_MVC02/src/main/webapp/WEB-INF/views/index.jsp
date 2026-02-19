<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management</title>

<!-- Bootstrap 5 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #0f172a;
        color: #ffffff;
        font-family: 'Segoe UI', sans-serif;
    }

    .card-dark {
        background-color: #1e293b;
        border-radius: 15px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.4);
        border: none;
    }

    .form-control {
        background-color: #334155;
        border: 1px solid #475569;
        color: #ffffff;
        border-radius: 10px;
    }

    .form-control::placeholder {
        color: #cbd5e1;
    }

    .form-control:focus {
        background-color: #334155;
        color: #ffffff;
        border-color: #38bdf8;
        box-shadow: 0 0 8px #38bdf8;
    }

    .table-dark-custom {
        background-color: #1e293b;
        color: #ffffff;
    }

    .table-dark-custom thead {
        background-color: #2563eb;
        color: white;
    }

    .btn-custom {
        border-radius: 8px;
    }
</style>

</head>
<body>

<div class="container py-5">

    <!-- Heading -->
    <div class="text-center mb-5">
        <h2 class="fw-bold text-info">Product Management System</h2>
        <p class="text-secondary">Add and manage your products</p>
    </div>

    <!-- Form Card -->
    <div class="card card-dark p-4 mb-5">
        <form:form action="addProduct" method="post" modelAttribute="product">

            <form:hidden path="id"/>

            <div class="row g-3 align-items-end">

                <div class="col-md-4">
                    <label class="form-label">Name</label>
                    <form:input path="name"
                        cssClass="form-control"
                        placeholder="Enter product name"/>
                </div>

                <div class="col-md-3">
                    <label class="form-label">Price</label>
                    <form:input path="price"
                        cssClass="form-control"
                        placeholder="Enter price"/>
                </div>

                <div class="col-md-3">
                    <label class="form-label">Quantity</label>
                    <form:input path="qty"
                        cssClass="form-control"
                        placeholder="Enter quantity"/>
                </div>

                <div class="col-md-2">
                    <button type="submit"
                        class="btn btn-info w-100 btn-custom fw-semibold">
                        Save
                    </button>
                </div>

            </div>

        </form:form>
    </div>

    <!-- Table Card -->
    <div class="card card-dark p-4">
        <div class="table-responsive">
            <table class="table table-dark table-hover align-middle text-center table-dark-custom">
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
                    <c:forEach items="${products}" var="pro">
                        <tr>
                            <td>${pro.id}</td>
                            <td>${pro.name}</td>
                            <td>₹ ${pro.price}</td>
                            <td>${pro.qty}</td>
                            <td>
                                <a href="update?id=${pro.id}"
                                   class="btn btn-sm btn-warning btn-custom">
                                   Update
                                </a>
                            </td>
                            <td>
                                <a href="delete?id=${pro.id}"
                                   class="btn btn-sm btn-danger btn-custom"
                                   onclick="return confirm('Are you sure you want to delete this product?');">
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
