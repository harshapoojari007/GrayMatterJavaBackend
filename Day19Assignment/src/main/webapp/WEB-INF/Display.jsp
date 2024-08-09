<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page isELIgnored="false" %>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<body>
<c:choose>
   
    <c:when test="${action == 'All'}">
       <h1 class="">Post Lists</h1>
        <c:forEach var="post" items="${postList}">
           <div class="container">
          <h3 class="">${post.title}</h3>
          <p class="mb-3">${post.id}</p>
          <p class="mb-2">${post.content}</p>
          <p >Posted by: <span class="fw-bold">${post.author}</span> </p>
          </div>
        
                 
            
        </c:forEach>
       
    </c:when>
    <c:otherwise>
         <div class="container">
          <h3 class="">${post.title}</h3>
          <p class="mb-3">${post.id}</p>
          <p class="mb-2">${post.content}</p>
          <p>Posted by: <span class="fw-bold">${post.author}</span> </p>
          </div>
    </c:otherwise>
</c:choose>
</body>
</html>