<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty sessionScope.user_data.getName()}">
    	<h2>I am a, ${sessionScope.user_data.getName()}!</h2>
    	<h2>My role is ${sessionScope.user_data.getRole()}!</h2>
	</c:if>
	<a href="profile/admin/register">Add Product</a>
	<a href="profile/admin/catalog">Product Catalog</a>
	
	<br><br>
		<form action="logout" method="POST">
        <button type="submit">Logout</button>
    </form>
</body>
</html>