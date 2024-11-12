<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .grid-container {
            display: grid;
            grid-template-columns: auto auto auto auto; /* 3 columns */
            gap: 10px; /* Gap between grid items */
        }
        .grid-item {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
  </style>
</head>
<body>
	<c:if test="${not empty sessionScope.user_data.getName()}">
    	<h2>Customer:  ${sessionScope.user_data.getName()}!</h2>
	</c:if>
		
		<table border="1" width="80%" align="center">
		    <tr>
		        <th>Product List</th>
		    </tr>
    
			<tr>
				<td class="grid-container">
				<c:forEach var="product" items="${product_list}">
			        <form action="cart" method="post" class="grid-item">
			        	<input type="hidden" name="customer_name" value="${sessionScope.user_data.getName()}"/> <br/><br/>
					    <input type="hidden" name="product_id" value="${product.id}"/> <br/><br/>
					        
					    <label for="name">Product Name:</label>
					    <input type="text" name="product_name" value="${product.name}" readonly /><br/><br/>
					    
					    <label for="type">Product Type:</label>
					    <input type="text" name="product_type" value="${product.type}" readonly /><br/><br/>
					    
					    <label for="price">Price:</label>
					    <input type="number" name="product_price" value="${product.price}" readonly /><br/><br/>
					    
					    <label for="quantity">Quantity:</label>
					    <input type="number" name="product_quantity" required/> <br/><br/>
					    
					    <button type="submit">Add to Cart</button>
					</form>
			
		    	</c:forEach>
		    	</td>
				
			</tr>
		</table>

</body>
</html>