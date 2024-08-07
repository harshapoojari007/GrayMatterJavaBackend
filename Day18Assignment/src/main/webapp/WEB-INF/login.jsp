<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="login">
<p>${error}</p>
<p>Username: <input type="text" name="username" id="username"></p>
<p>Password: <input type="password" name="password" id="password"></p>
<input type="submit" value="Login">
</form>
</body>
</html>