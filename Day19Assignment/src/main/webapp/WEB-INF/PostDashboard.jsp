<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<style>
a{
color:white;
text-decoration:none;
font-weight:bold;
}
</style>
<body >
<div class="container mt-5">

<h1>Post Dashboard</h1>
<div>
<p>Welcome user ${username }!</p>
</div>
<div class="">
<button class="btn btn-primary "><a href="add">Add Post</a></button>
<button class="btn btn-primary"><a href="delete">Delete Post</a></button>
<button class="btn btn-primary"><a href="update">Update Post</a></button>
<button class="btn btn-primary"><a href="get">Get Post</a></button>
<button class="btn btn-primary"><a href="getAll">Get All Posts</a></button>
</div>
<div>
<p class="text-success mt-5">${message}</p>
</div>
</div>
</body>
</html>