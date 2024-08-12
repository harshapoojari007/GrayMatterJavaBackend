<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">

        <h2>Sign up</h2>
        <p class="text-danger">${error}</p>
        <form action="signup">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" name="username" id="username" placeholder="Username">
            </div>
             <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Email">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Password" min="8">
            </div>
             <div class="mb-3">
                 <label for="role" class="form-label">Role</label>
                <select class="form-control" name="role" id="role">
                   <option value="admin">Admin</option>
                   <option value="user">User</option>
                </select>
                </div>
            <button type="submit" class="btn btn-primary">Sign up</button>
            <p>Don't have an account?<a href="dologin" class="text-decoration-none">Login</a></p>
        </form>
    </div>
</body>
</html>