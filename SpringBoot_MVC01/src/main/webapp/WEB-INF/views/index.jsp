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

</head>
<body class="bg-light">

<div class="container mt-5">

    <!-- Page Heading -->
    <div class="text-center mb-4">
        <h2 class="fw-bold text-primary">Product Management System</h2>
    </div>

    <!-- Product Form Card -->
    <div class="card shadow mb-5">
        <div class="card-header bg-primary text-white">
            Add / Update Product
        </div>
        <div class="card-body">

            <form:form action="addProduct" method="post" modelAttribute="product" class="row g-3">
                
                <form:hidden path="id"/>

                <div class="col-md-4">
                    <form:label path="name" class="form-label">Product Name</form:label>
                    <form:input path="name" class="form-control" placeholder="Enter product name"/>
                </div>

                <div class="col-md-4">
                    <form:label path="price" class="form-label">Price</form:label>
                    <form:input path="price" class="form-control" placeholder="Enter price"/>
                </div>

                <div class="col-md-4">
                    <form:label path="qty" class="form-label">Quantity</form:label>
                    <form:input path="qty" class="form-control" placeholder="Enter quantity"/>
                </div>

                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-success px-4">
                        Save Product
                    </button>
                </div>

            </form:form>
        </div>
    </div>

    <!-- Product Table Card -->
    <div class="card shadow">
        <div class="card-header bg-dark text-white">
            Product List
        </div>
        <div class="card-body table-responsive">

            <table class="table table-bordered table-hover text-center align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>Id</th>
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
                                <a href="delete?id=${pro.id}" class="btn btn-danger btn-sm">
                                    Delete
                                </a>
                            </td>
                            <td>
                                <a href="update?id=${pro.id}" class="btn btn-warning btn-sm">
                                    Update
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
