<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page isELIgnored="false" %>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<body>
<c:choose>
   
    <c:when test="${action == 'All'}">
        <h1>Employee Lists</h1>
         <table>
         <tr>
          <th>Name</th>
          <th>Id</th>
          <th>Salary</th>
          
         </tr>
        <c:forEach var="emp" items="${emp}">
           <tr>
          <td>${emp.empName}</td>
          <td>${emp.empId}</td>
          <td>${emp.empSalary}</td>
         
         </tr>
                 
            
        </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1>Name: ${emp.empName}</h1>
        <h1>Id: ${emp.empId}</h1>
        <h1>Age: ${emp.empSalary}</h1>
        
    </c:otherwise>
</c:choose>
</body>
</html>