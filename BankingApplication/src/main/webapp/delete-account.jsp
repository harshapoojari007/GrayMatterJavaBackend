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
            <h1 style="display: block;"> <img src="logo.jpg" alt="" width="50px" height="40px">GHP BANK</h1>
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

    <div class="container mt-4">
        <h1>Delete an Account</h1>
        <form id="deleteAccountForm" action="AccountOperations">
        <input type="hidden" action="deleteAccount">
           <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="accountId" required name="username">
            </div>
            <div class="mb-3">
                <label for="accountId" class="form-label">Account Number</label>
                <input type="text" class="form-control" id="accountId" required name="accountNumber">
            </div>
            <button type="submit" class="btn btn-danger">Delete Account</button>
        </form>
        <a href="Accounts.jsp" class="btn btn-secondary mt-3">Back to Dashboard</a>
    </div>
</body>
</html>