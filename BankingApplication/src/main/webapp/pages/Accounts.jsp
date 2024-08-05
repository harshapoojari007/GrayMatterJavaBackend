<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accounts</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../style.css">
    <script src="https://kit.fontawesome.com/70562393cb.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="pagestyle.css">

</head>

    <script type="text/javascript">
        function showAlert(message) {
            if (message) {
                alert(message);
            }
        }
    </script>



<body onload="showAlert('<%= request.getAttribute("alertMessage") != null ? request.getAttribute("alertMessage") : "" %>')">
    <header>
        <div>
            <h1 style="display: block;"> <img src="../logo.jpg" alt="" width="50px" height="40px">GHP BANK</h1>
        </div>
        <nav>
            <div class="ul">
                <ul type="none">
                    <a href="../index.jsp"><li>HOME</li></a>
                    <a href="Accounts.jsp"><li>ACCOUNTS</li></a>
                    <li>CARDS</li>
                    <li>DEPOSITS</li>

                </ul>
            </div>

        </nav>
    </header>



    <div class="container dashboard-container">
        <h1>Banking Dashboard</h1>
        <div class="d-flex flex-column align-items-center">
            <a href="create-account.jsp" class="btn btn-primary">Create an Account</a>
            <a href="" class="btn btn-primary btnD">Account Details</a>
            
            <a href="delete-account.jsp" class="btn btn-danger">Delete Account</a>
            <a href="update-account.jsp" class="btn btn-warning">Update Account Details</a>
            <a href="withdraw-money.jsp" class="btn btn-success">Withdraw Money</a>
            <a href="add-money.jsp" class="btn btn-info">Add Money</a>
            <a href="updatePin.jsp" class="btn btn-primary">Update PIN</a>
        </div>
    </div>
</body>
</html>