<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body  class="">
<div class="container mt-5">

<h4>Welcome! user ${sessionScope.username} </h4>
<div class="shadow p-3 pb-4 rounded">
<h3 class="mt-2 mb-3">Customer and Order Dashboards</h3>
<button class="btn btn-primary"> <a href="doCustomerDashboard"  style="color:white;text-decoration:none">Customer Dashboard</a></button>
<button class="btn btn-primary"> <a href="doOrderDashboard"  style="color:white;text-decoration:none"> Order Dashboard</a></button>
</div>
<form action="logout" method="post">
       <button type="submit" class="btn btn-danger mt-4">Logout</button>
    </form>


</div>

</body>
</html>