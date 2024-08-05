<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/70562393cb.js" crossorigin="anonymous"></script>
    <title>Welcome</title>

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
            <h1 style="display: block;"> <img src="logo.jpg" alt="" width="50px" height="40px">GHP BANK</h1>
        </div>
        <nav>
            <div class="ul">
                <ul type="none">
                   <a href="index.jsp"> <li>HOME</li></a>
                    <a href="pages/Accounts.jsp"><li>ACCOUNTS</li></a>
                    <li>CARDS</li>
                    <li>DEPOSITS</li>

                </ul>
            </div>

        </nav>
 
     <% 
        String username = request.getParameter("username");
    %>

    <% if (username != null) { %>
        <div  class="loginbtn">
            Welcome, <%= username %>!
            
        </div>
    <% } else { %>
        <div class="loginbtn">
            <a href="/pages/login.jsp">LOGIN</a>
        </div>
    <% } %>
    </header>
    <div> 
        <div class="maindiv1">
            <div>
                <h1>Building a better</h1>
                <h1>financial future together</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum velit eveniet modi dolorum. Cumque
                    laboriosam, quam provident error hic aspernatur consequatur, sint eum, rem porro perferendis sequi
                    praesentium est tenetur?F</p>
            </div>
            <div>
                <img src="mainPic.PNG" alt="">
            </div>
        </div>
        <div class="maindiv2">
            <div>
                <h2>600K </h2>
                <p>Customers</p>
            </div>
            <div>
                <h2>$ 12M+</h2>
                <p>Transactions</p>
            </div>
            <div>
                <h2>250 B </h2>
                <p>Money Managed</p>
            </div>
            <div>
                <h2>76% </h2>
                <p>YearlyGrowth</p>
            </div>
        </div>

    </div>
    <footer>
        <p>We use cookies to provide a user-friendly experience. By continuing to browse this site, you agree to the use
            of cookies. To view our cookie policy, click here</p>

        <p>© Copyright GHP Bank Ltd. Terms and Conditions Privacy Policy</p>
    </footer>
</body>

</html>