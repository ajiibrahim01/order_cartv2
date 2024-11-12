<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

</head>
<body>
   
        <h2>Login</h2>
        <form action="auth" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" required>

            <label for="password">Password:</label>
            <input type="password"  name="password" required>

            <button type="submit">Login</button>
        </form>

</body>
</html>