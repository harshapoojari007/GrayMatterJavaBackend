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

    <div class="container mt-4">
        <h1>Create a New Account</h1>
        <form id="createAccountForm" action="AccountOperations">
        <input type="hidden" name="action" value="createAccount">
            <div class="mb-3">
                <label for="accountName" class="form-label">Account Holder Name</label>
                <input type="text" class="form-control" id="accountName" name="name" required>
            </div>
            <div class="mb-3">
                <label for="accountName" class="form-label">Username</label>
                <input type="text" class="form-control" id="accountName" name="username" required>
            </div>
            <div class="mb-3">
                <label for="accountName" class="form-label">Mobile</label>
                <input type="number" class="form-control" id="" name="mobile" required>
            </div>
            <div class="mb-3">
                <label for="accountName" class="form-label">Adhaar Number</label>
                <input type="text" class="form-control" id="" name="adhaar" required>
            </div>
            <div class="mb-3">
                <label for="accountName" class="form-label">Address</label>
                <!-- <input type="text" class="form-control" id="accountName" name="" required> -->
                <textarea class="form-control" name="address" id=""></textarea>
            </div>

            <div class="mb-3">
                <label for="account_type" class="form-label">Account Type</label>
                <select class="form-select" name="account_type" id="" required>
                    <option value="" disabled selected>Select your Account Type</option>
                    <option value="Savings Account" name="account">Savings Account</option>
                    <option value="Current Account" name="account">Current Account</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="accountName" class="form-label">Card Pin</label>
                <input type="number" class="form-control" id="" name="card_pin" required>
            </div>
            <button type="submit" class="btn btn-primary">Create Account</button>
        </form>
        <a href="Accounts.jsp" class="btn btn-secondary mt-3">Back to Dashboard</a>
    </div>
</body>
</html>