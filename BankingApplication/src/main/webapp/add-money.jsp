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
    </header>

    <div class="container mt-4">
        <h1>Add Money</h1>
        <form id="addMoneyForm" action="AccountOperations">
        <input type="hidden" action="addMoney">
            <div class="mb-3">
                <label for="accountId" class="form-label">Account ID</label>
                <input type="text" class="form-control" id="accountId" required>
            </div>
            <div class="mb-3">
                <label for="amount" class="form-label">Amount</label>
                <input type="number" class="form-control" id="amount" required>
            </div>
            <button type="submit" class="btn btn-info">Add Money</button>
        </form>
        <a href="Accounts.jsp" class="btn btn-secondary mt-3">Back to Dashboard</a>
    </div>
</body>
</html>