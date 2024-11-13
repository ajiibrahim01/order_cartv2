<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Register Product</h1>
  <form action="product/save" method="POST">
  
  		<label for="productId">Product Id:</label>
        
        <input type="text"  name="product_id" required>
        <br><br>

        <label for="productName">Product Name:</label>
        
        <input type="text"  name="product_name" required>
        <br><br>


        <label for="productType">Product Type:</label>
        <input type="text"  name="product_type" required>
        <br><br>


        <label for="productPrice">Price:</label>
        <input type="number"  name="product_price" required >
        <br><br>

     
        <button type="submit">Add Product</button>
    </form>
    <br><br>
    <a href="/shop2/auth/profile">Go Back to Profile</a>
</body>
</html>