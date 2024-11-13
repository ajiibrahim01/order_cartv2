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
	<c:set var="product" value="${product_by_id}" />

	<form action="save/${product.id}" method="post">
	

	    <input type="hidden" name="product_id" value="${product.id}"/> <br/><br/>
	        
	    <label for="name">Product Name:</label>
	    <input type="text" name="product_name" value="${product.name}" required /><br/><br/>
	    
	    <label for="type">Product Type:</label>
	    <input type="text" name="product_type" value="${product.type}" required /><br/><br/>
	    
	    <label for="price">Price:</label>
	    <input type="number" name="product_price" value="${product.price}" required /><br/><br/>
	    
	    <button type="submit">Update Product</button>
	</form>
	<br><br>
	<a href="/shop2/auth/profile">Go Back to Profile</a>
</body>
</html>