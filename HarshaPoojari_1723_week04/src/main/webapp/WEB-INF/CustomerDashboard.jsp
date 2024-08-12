<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page isELIgnored="false" %>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<style>
a{
color:white;
text-decoration:none;
font-weight:bold;
}
</style>
<body>

<div class="container mt-5">

<h1>Customer Dashboard</h1>
<div>
<p>User: ${sessionScope.username}      Role: ${sessionScope.role}</p>
</div>
<div class="shadow p-4 pb-4 rounded">
<button class="btn btn-primary "><a href="doAddCustomer">Add Customer</a></button>
<button class="btn btn-primary"><a href="doDeleteCustomer">Delete Customer</a></button>
<button class="btn btn-primary"><a href="doUpdateCustomer">Update Customer</a></button>
<button class="btn btn-primary"><a href="doGetCustomer">Get Customer</a></button>
<c:choose>
<c:when test="${sessionScope.role=='admin'}">
<button class="btn btn-primary"><a href="getAllCustomer">Get All Customers</a></button>
</c:when>
</c:choose>
<button class="btn btn-primary"><a href="welcome">Go Home</a></button>
</div>
<div>
<p class="text-success mt-5 fw-bold">${message}</p>
</div >
</div>

<div class="container mt-5">
<c:choose>
   
    <c:when test="${action == 'addCustomer'}">
    <div class="container mt-5">
        <h2>Add Customer</h2>
        <form action="addCustomer">
            <div class="mb-3">
                <label for="id" class="form-label">Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
           <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Name">
            </div>
       
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Email">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
    </c:when>
    <c:when test="${action == 'deleteCustomer'}">
        <div class="container mt-5">
        <h2>Delete Customer</h2>
        <form action="deleteCustomer">
            <div class="mb-3">
                <label for="id" class="form-label">Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
       
            <button type="submit" class="btn btn-primary">Delete</button>
        </form>
    </div>
    </c:when>
     
      <c:when test="${action == 'updateCustomer'}">
           <div class="container mt-5">
          <h2>Update Customer</h2>
          <form action="updateCustomer">
            <div class="mb-3">
                <label for="id" class="form-label">Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
           <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Name">
            </div>
       
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Email">
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div> 
      </c:when>
      <c:when test="${action == 'getCustomer'}">
          <div class="container mt-5">
          <h2>Get Customer</h2>
          <form action="getCustomer">
            <div class="mb-3">
                <label for="id" class="form-label">Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
       
            <button type="submit" class="btn btn-primary">Get Customer</button>
        </form>
    </div>
      </c:when>
      <c:when test="${function == 'getAllCustomer'}">
                 <div class="container">
                  <h2>Customers</h2> 
                    
                  <table class="table table-hover">
                  <thead>
                      <tr>
                       <th>Id</th>
                       <th>Name</th>
                      <th>Email</th>
                     </tr>
                  </thead>
                     
                 <tbody>
                   <c:forEach var="cust" items="${customerList}">  
                     <tr>
                       <td>${cust.id}</td>
                       <td>${cust.name}</td>
                       <td>${cust.email}</td>
                     </tr>
                      </c:forEach>
                   </tbody>
                    
                 </table>
         
         </div>
      </c:when>
      <c:when test="${function == 'getCustomer'}">
      <div class="container">
                  <h2>Customer</h2> 
                  <table class="table table-hover">
                  <thead>
                      <tr>
                       <th>Id</th>
                       <th>Name</th>
                      <th>Email</th>
                     </tr>
                  </thead>
                 <tbody>
                     <tr>
                       <td>${customer.id}</td>
                       <td>${customer.name}</td>
                       <td>${customer.email}</td>
                     </tr>
                   </tbody>
                 </table>
      </c:when>
</c:choose>
</div>


</body>
</html>





