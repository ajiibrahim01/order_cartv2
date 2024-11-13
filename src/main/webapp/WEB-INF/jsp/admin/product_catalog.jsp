<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Product Catalog</h2>
	<h3 style="margin-left: 200px;"><a href="register">Add Product</a></h3>

<table border="1" width="80%" align="center">
    <tr>
        <th>No</th>
        <th>Name</th>
        <th>Type</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    
    <c:forEach var="product" items="${product_list}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.type}</td>
            <td>${product.price}</td>
            <td><a href="view/${product.id}">View</a></td>
        </tr>
    </c:forEach> 
</table>
 	<br><br>
 	<a href="/shop2/auth/profile">Go Back to Profile</a>
</body>
</html>