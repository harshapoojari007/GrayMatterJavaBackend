<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page isELIgnored="false" %>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Dashboard</title>
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

<h1>Order Dashboard</h1>
<div>
<p> User: ${sessionScope.username}      Role: ${sessionScope.role}</p>
</div>
<div class="shadow p-4 pb-4 rounded">
<button class="btn btn-primary "><a href="doAddOrder">Add Order</a></button>
<button class="btn btn-primary"><a href="doDeleteOrder">Delete Order</a></button>
<button class="btn btn-primary"><a href="doUpdateOrder">Update Order</a></button>
<button class="btn btn-primary"><a href="doGetOrder">Get Order</a></button>
<c:choose>
<c:when test="${sessionScope.role=='admin'}">
<button class="btn btn-primary"><a href="getAllOrder">Get All Orders</a></button>

</c:when>
</c:choose>
<button class="btn btn-primary"><a href="doGetOrderCustomer">Get Orders of Customer</a></button>
<button class="btn btn-primary"><a href="welcome">Go Home</a></button>
</div>
<div>
<p class="text-success mt-5 fw-bold">${message}</p>
</div >
</div>

<div class="container mt-5">
<c:choose>
   
    <c:when test="${action == 'addOrder'}">
    <div class="container mt-5">
        <h2>Add Order</h2>
        <form action="addOrder">
            <div class="mb-3">
                <label for="id" class="form-label">Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
           <div class="mb-3">
                <label for="totalAmount" class="form-label">Total Amount</label>
                <input type="text" class="form-control" name="totalAmount" id="totalAmount" placeholder="Total Amount">
            </div>
       
            <div class="mb-3">
                <label for="customerId" class="form-label">Customer Id</label>
                <input type="customerId" class="form-control" name="customerId" id="customerId" placeholder="CustomerId">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
    </c:when>
    <c:when test="${action == 'deleteOrder'}">
        <div class="container mt-5">
        <h2>Delete Order</h2>
        <form action="deleteOrder">
            <div class="mb-3">
                <label for="id" class="form-label">Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
       
            <button type="submit" class="btn btn-primary">Delete</button>
        </form>
    </div>
    </c:when>
     
      <c:when test="${action == 'updateOrder'}">
           <div class="container mt-5">
          <h2>Update Order</h2>
          <form action="updateOrder">
            <div class="mb-3">
                <label for="id" class="form-label">Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
           <div class="mb-3">
                <label for="totalAmount" class="form-label">Total Amount</label>
                <input type="text" class="form-control" name="totalAmount" id="totalAmount" placeholder="Total Amount">
            </div>
       
            <div class="mb-3">
                <label for="customerId" class="form-label">Customer Id</label>
                <input type="customerId" class="form-control" name="customerId" id="customerId" placeholder="CustomerId">
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div> 
      </c:when>
      <c:when test="${action == 'getOrder'}">
          <div class="container mt-5">
          <h2>Get Order</h2>
          <form action="getOrder">
            <div class="mb-3">
                <label for="id" class="form-label">Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
       
            <button type="submit" class="btn btn-primary">Get Order</button>
        </form>
    </div>
      </c:when>
       <c:when test="${action == 'getOrderCustomer'}">
          <div class="container mt-5">
          <h2>Get Order</h2>
          <form action="getOrderCustomer">
            <div class="mb-3">
                <label for="id" class="form-label">Customer Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
       
            <button type="submit" class="btn btn-primary">Get Order</button>
        </form>
    </div>
      </c:when>
      <c:when test="${function == 'getAllOrder'}">
                 <div class="container">
                  <h2>Orders</h2> 
                    
                  <table class="table table-hover">
                  <thead>
                      <tr>
                       <th>Id</th>
                       <th>Total Amount</th>
                      <th>Order Date</th>
                      <th>Customer Id</th>
                     </tr>
                  </thead>
                 <tbody>
                 <c:forEach var="ord" items="${orderList}">       
                     <tr>
                       <td>${ord.id}</td>
                       <td>${ord.totalAmount}</td>
                       <td>${ord.orderDate}</td>
                       <td>${ord.customerId}</td>
                     </tr>
                      </c:forEach>
                   </tbody>
                 </table>
          
         </div>
      </c:when>
      <c:when test="${function == 'getOrder'}">
      <div class="container">
                  <h2>Order</h2> 
                  <table class="table table-hover">
                  <thead>
                      <tr>
                       <th>Id</th>
                       <th>Total Amount</th>
                      <th>Order Date</th>
                      <th>Customer Id</th>
                     </tr>
                  </thead>
                 <tbody>
                     <tr>
                       <td>${order.id}</td>
                       <td>${order.totalAmount}</td>
                       <td>${order.orderDate}</td>
                       <td>${order.customerId}</td>
                     </tr>
                   </tbody>
                 </table>
      </c:when>
           <c:when test="${function == 'getCustomerOrder'}">
                 <div class="container">
                  <h2>Orders Of Customer</h2> 
                    
                  <table class="table table-hover">
                  <thead>
                      <tr>
                       <th>Id</th>
                       <th>Total Amount</th>
                      <th>Order Date</th>
                      <th>Customer Id</th>
                     </tr>
                  </thead>
                 <tbody>
                  <c:forEach var="ord" items="${orderList}">      
                     <tr>
                       <td>${ord.id}</td>
                       <td>${ord.totalAmount}</td>
                       <td>${ord.orderDate}</td>
                       <td>${ord.customerId}</td>
                     </tr>
                         </c:forEach>
                   </tbody>
                 </table>
       
         </div>
      </c:when>
</c:choose>
</div>


</body>
</html>