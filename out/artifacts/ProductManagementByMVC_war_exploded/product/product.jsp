<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/3/2020
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>
    Products List
</h1>
<a href="./product?action=create">Add new product</a>
<br>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Brand</th>
        <th align="center" colspan="2">Action</th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="./product?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getBrand()}</td>
            <td><a href="./product?action=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="./product?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
