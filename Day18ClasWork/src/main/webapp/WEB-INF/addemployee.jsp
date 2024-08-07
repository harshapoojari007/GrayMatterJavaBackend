<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add EMployee</title>
</head>
<body>
<form action="employee/add">
<p>Employee Name: <input type="text" name="name" id="name"></p>
<p>Employee Id: <input type="text" name="id" id="id"></p>
<p>Employee Salary: <input type="text" name="salary" id="salary"></p>
<input type="submit" value="Add">
</form>
</body>
</html>