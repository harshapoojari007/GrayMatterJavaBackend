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
    
     <% 
        String username = request.getParameter("username");
    %>
    
        <div>
            <h1 style="display: block;">FoodFoodie</h1>
        </div>
        <nav>
            <div class="ul">
                <ul type="none">
                    <a href="index.jsp"><li>HOME</li></a>
                    <a href="about.jsp"><li>ABOUT US</li></a>
                     <% if (username == "admin") { %>
                     <a href="items.jsp"><li>ITEMS</li></a>
                     <% } %>
                     
                    <% if (username != null) { %>
                    <a href="myorders.jsp"><li>MY ORDERS</li></a>
                     <% } %>
                </ul>
            </div>

        </nav>
       

    <% if (username != null) { %>
        <div  class="loginbtn">
            Welcome, <%= username %>!
            
        </div>
    <% } else { %>
        <div class="loginbtn">
            <a href="login.jsp">LOGIN</a>
        </div>
    <% } %>
    </header>
    <div> 
        <div class="maindiv1">
            <div>
                <h1>Delicious food</h1>
                <h1>delivered at</h1>
                <h1>your doorstep</h1>
                <p>Yes, we have the best receipies in town</p>
                
                <div class="order">
                <a href="order.jsp" >ORDER NOW</a></div>
                
            </div>
            <div>
                <img src="mainphoto.jpg" alt="">
            </div>
        </div>
        <div class="maindiv2">
            <div>
                <h2>100K </h2>
                <p>Customers</p>
            </div>
            <div>
                <h2>10K +</h2>
                <p>Orders</p>
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

        <p>© Copyright FoodFoodie Ltd. Terms and Conditions Privacy Policy</p>
    </footer>
</body>

</html>