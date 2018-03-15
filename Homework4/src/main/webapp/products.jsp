<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>

<h3>Product List</h3>


<table border="1" cellpadding="5" cellspacing="5" >
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Manufacturer</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${list}" var="list" >
        <tr>
            <td>${list.NAME}</td>
            <td>${list.PRICE}</td>
            <td>${list.manufacturer}</td>
            <td><a href="/products?action=deleteProduct&id=${list.ID}">delete</a> </td>
            </td>
        </tr>
    </c:forEach>
</table>


<h3>Manufacturing</h3>
<form method="get" action="/manufacturers">
    <input type="submit" name="showManufacturer" value="showManufacturer">
</form>

</body>
</html>