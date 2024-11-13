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
	<a href="list">Go/Back to List</a>
	<br><br>
	<a href="/shop2/auth/profile">Go Back to Profile</a>

	<table border="1" width="50%" align="center">
	<caption><h4>Order Cart</h4></caption>
	<tr>
		<th style="border: none;"><c:if test="${not empty sessionScope.user_data.getName()}">
    	<h5>Customer: ${sessionScope.user_data.getName()}</h5>
	</c:if></th>
	</tr>
	<tr>
		<th>Code</th>
		<th>Name</th>
		<th>Type</th>
		<th>Price</th>
		<th>Qty</th>
		<th>Total</th>
			
	</tr>
									
	
		<c:forEach var="item" items="${sessionScope.order_cart.orders}">
		<tr align="center">
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td>${item.type}</td>
			<td>${item.price}</td>
			<td>${item.quantity}</td>
			<td>${item.itemPrice() }</td>
		</tr>
		</c:forEach>
		<tr align="center">
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
		<c:set var="total" value="${sessionScope.order_cart.totalPrice()}" />
			<td style="border: none;">Total:</td>
			<td style="border: none;">${total}</td>
		</tr>
		<tr>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			
		</tr>
		<tr align="center">
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;"></td>
			<td style="border: none;, text-align: center;">
				<form action="submit" method="post">
					<button type="submit">Place to Order</button>
				</form>
			</td>
		</tr>
			
	</table>
	
	
</body>
</html>