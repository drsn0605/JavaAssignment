<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #f3e8ff, #e9d5ff);
        margin: 0;
        padding: 30px;
    }

    .container {
        width: 80%;
        margin: auto;
        background: #ffffff;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 8px 20px rgba(128, 0, 128, 0.2);
    }

    h2 {
        text-align: center;
        color: #6b21a8;
        margin-bottom: 20px;
    }

    form {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 15px;
        margin-bottom: 30px;
    }

    label {
        color: #7e22ce;
        font-weight: bold;
    }

    input[type="text"], input[type="number"] {
        padding: 8px;
        border: 1px solid #d8b4fe;
        border-radius: 6px;
        outline: none;
    }

    input[type="text"]:focus,
    input[type="number"]:focus {
        border-color: #9333ea;
        box-shadow: 0 0 5px rgba(147, 51, 234, 0.4);
    }

    input[type="submit"] {
        grid-column: span 2;
        padding: 10px;
        background-color: #a855f7;
        color: white;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        font-weight: bold;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #9333ea;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table th {
        background-color: #c084fc;
        color: white;
        padding: 10px;
    }

    table td {
        padding: 10px;
        text-align: center;
        border-bottom: 1px solid #e9d5ff;
    }

    table tr:hover {
        background-color: #f5e8ff;
    }

    a {
        text-decoration: none;
        color: #6b21a8;
        font-weight: bold;
    }

    a:hover {
        color: #9333ea;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Product Management</h2>

    <form:form action="addProduct" method="post" modelAttribute="product">
        <form:hidden path="id"/>

        <form:label path="name">Name</form:label>
        <form:input path="name"/>

        <form:label path="price">Price</form:label>
        <form:input path="price"/>

        <form:label path="qty">Qty</form:label>
        <form:input path="qty"/>

        <input type="submit" value="Save Product">
    </form:form>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Qty</th>
            <th colspan="2">Action</th>
        </tr>

        <c:forEach items="${products}" var="pro">
        <tr>
            <td>${pro.id}</td>
            <td>${pro.name}</td>
            <td>${pro.price}</td>
            <td>${pro.qty}</td>
            <td><a href="delete?id=${pro.id}">Delete</a></td>
            <td><a href="update?id=${pro.id}">Update</a></td>
        </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>
