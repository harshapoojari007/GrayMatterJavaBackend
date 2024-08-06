<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/70562393cb.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="pagestyle.css">
</head>
<body>
    <header>
        <div>
            <h1 style="display: block;"> <img src="../logo.jpg" alt="" width="50px" height="40px">GHP BANK</h1>
        </div>
        <nav>
            <div class="ul">
                <ul type="none">
                    <a href="index.jsp"><li>HOME</li></a>
                    <a href="Accounts.jsp"><li>ACCOUNTS</li></a>
                    <li>CARDS</li>
                    <li>DEPOSITS</li>

                </ul>
            </div>

        </nav>
        <%
        HttpSession session1 = request.getSession(false); // false means do not create a new session if one doesn't exist
        String username1 = (session1 != null) ? (String) session1.getAttribute("username") : null;

        if (username1 == null) {%>
            
        <div class="loginbtn">
            <a href="login.jsp">LOGIN</a>
        </div>
       <%   }else {%>
    
    <h2 class="loginbtn"><%= username1 %>!</h2>
    <div class="loginbtn">
    <a href="logout.jsp">Logout</a>
    </div>
     <%   }%>
    </header>

    <div class="container form-container">
        <h1>Update Your PIN</h1>
        <form id="updatePinForm" action="AccountOperations">
        <input type="hidden" action="updatePin">
            <div class="mb-3">
                <label for="currentPin" class="form-label">Current PIN</label>
                <input type="password" class="form-control" id="currentPin" required>
            </div>
            <div class="mb-3">
                <label for="newPin" class="form-label">New PIN</label>
                <input type="password" class="form-control" id="newPin" required>
            </div>
            <div class="mb-3">
                <label for="confirmNewPin" class="form-label">Confirm New PIN</label>
                <input type="password" class="form-control" id="confirmNewPin" required>
            </div>
            <button type="submit" class="btn btn-primary">Update PIN</button>
        </form>
        <a href="Accounts.jsp" class="btn btn-secondary mt-3">Back to Dashboard</a>
    </div>
</body>
</html>