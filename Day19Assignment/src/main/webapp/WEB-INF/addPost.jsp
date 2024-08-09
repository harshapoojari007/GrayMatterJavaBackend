<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Post</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
        <h2>Add Post</h2>
        <form action="addPost">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" class="form-control" name="title" id="title" placeholder="Title">
            </div>
           <div class="mb-3">
                <label for="id" class="form-label">Id</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id">
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">Content</label>
               <textarea class="form-control" name="content" id="content" row="5" col="10" ></textarea>
            </div>
            <div class="mb-3">
                <label for="author" class="form-label">Author</label>
                <input type="text" class="form-control" name="author" id="author" placeholder="Author">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>

</body>
</html>