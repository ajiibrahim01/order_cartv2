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
	<h1>PROFILE</h1>
	<c:if test="${not empty sessionScope.user_data.getName()}">
    	<h2>Hello, ${sessionScope.user_data.getName()}!</h2>
    	<h2>I am a ${sessionScope.user_data.getRole()}!</h2>
	</c:if>
		<a href="profile/customer/list">Product List</a>
		<a href="profile/customer/cart">Order Cart</a>
</body>
</html>