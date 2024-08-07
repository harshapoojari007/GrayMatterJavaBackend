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
        <h1>Student Lists</h1>
         <table>
         <tr>
          <th>Name</th>
          <th>Id</th>
          <th>Age</th>
          <th>Mobile</th>
         </tr>
        <c:forEach var="stu" items="${sts}">
           <tr>
          <td>${stu.name}</td>
          <td>${stu.id}</td>
          <td>${stu.age}</td>
          <td>${stu.mobile}</td>
         </tr>
                 
            
        </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1>Name: ${stu.name}</h1>
        <h1>Id: ${stu.id}</h1>
        <h1>Age: ${stu.age}</h1>
        <h1>Mobile: ${stu.mobile}</h1>
    </c:otherwise>
</c:choose>
</body>
</html>