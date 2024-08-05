<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/70562393cb.js" crossorigin="anonymous"></script>
</head>

   <script type="text/javascript">
        function showAlert(message) {
            if (message) {
                alert(message);
            }
        }
    </script>

<body style="background-color: rgb(202, 200, 198);" onload="showAlert('<%= request.getAttribute("alertMessage") != null ? request.getAttribute("alertMessage") : "" %>')">
    <div class="regForm">
        <form action="RegisterServlet" >
            <h1>Register</h1>
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
              </div>
              <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" aria-describedby="emailHelp" name="username">
                <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" min="8" name="password">
              </div>

              <div>
              <button type="submit" class="btn btn-primary" style="width: 100%;">Register</button>
            
               <p style="font-size: 15px; margin-top: 2px;">Already a user?<a href="login.jsp" style="color: rgb(28, 28, 245);">Login</a> </p>
            </div>
        </form>
    </div>
</body>
</html>