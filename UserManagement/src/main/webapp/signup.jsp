<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Sign up</h1>
<form action="UserInfoServlet">
<p>User Id: <input type="text" name="userid" id="userid" placeholder="userid" required></p>
<p>Username: <input type="text" name="username" id="username" placeholder="username" required></p>
<p>Mobile:  <input type="text" name="mobile"  id="mobile" placeholder="mobile" required></p>
<p>Email:      <input type="email" name="email"  id="email" placeholder="email" required></p>
<p>Password:   <input type="password" name="pwd" id="pwd" placeholder="password" required></p>

<button type="submit" value="submit">Sign Up</button> 
</form>
</body>
</html>