<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manufacturer List</title>
</head>
<body>

<h3>Manufacturer List</h3>


<table border="1" cellpadding="5" cellspacing="5" >
    <tr>
        <th>Name</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${manufacturerList}" var="manufacturerList" >
        <tr>
            <td>${manufacturerList.NAME}</td>
            <td><a href="/manufacturers?action=deleteManufacturer&id=${manufacturerList.ID}">delete</a> </td>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>############Manufacturer add###########</h3>
<form method="get" action="/manufacturers">
    Name    <input type="text" name="name">
    <input type="submit" name="addManufacturer" value="addManufacturer">
</form>

<h3>############Product add###########</h3>
<form method="get" action="/products">
    Name    <input type="text" name="name">
    Price    <input type="text" name="price">
    <select name="MANUFACTURER_ID">
        <option disabled>Выберите производителя</option>
        <c:forEach items="${manufacturerList}" var="manufacturerList">
            <option value=${manufacturerList.ID} >${manufacturerList.NAME}</option>
        </c:forEach>
    </select>
    <input type="submit" name="addProduct" value="addProduct">
</form>

</body>
</html>