<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Skiner
  Date: 21.01.2018
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework4</title>
</head>
    <h3>############manufacturers Menegment###########</h3>

<body>
<h3>Manufacturing</h3>
<form method="get" action="/manufacturers">
    <input type="submit" name="showManufacturer" value="showManufacturer">
</form>

<h3>Products</h3>
<form method="get" action="/products">
    <input type="submit" name="showProduct" value="showProduct">
</form>

</body>
</html>
