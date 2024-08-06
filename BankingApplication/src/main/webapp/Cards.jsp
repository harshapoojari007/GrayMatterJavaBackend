<%@ page import="java.sql.*, javax.sql.*, javax.naming.*" %>
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
    
        <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
          
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .h1 {
            text-align: center;
            color: #007BFF;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #007BFF;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
    
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

         <%if(username1==null){%>
         <div class="container" color="black">
            <h1 class="h1">Please Login to view the Debit Card</h1>
            <% }else {%>
            <div class="container" color="black">
            <h1 class="h1">Card Details</h1>
        <%
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/bankingdb";
            String user = "root";
            String password = "password";
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                // Load and register JDBC driver (MySQL example)
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Establish a connection
                conn = DriverManager.getConnection(url, user, password);
                
                // Get the username parameter from the request
                String username = (session1 != null) ? (String) session1.getAttribute("username") : null;
                
                // SQL query to fetch account details
                String sql = "SELECT * FROM card WHERE username = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                
                // Execute the query
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
        %>
        <table>
            <tr><th>Username</th><td><%= rs.getString("username") %></td></tr>
            <tr><th>Card Number</th><td><%= rs.getString("card_no") %></td></tr>
            <tr><th>Card CVV</th><td><%= rs.getString("card_cvv") %></td></tr>
            <tr><th>Expiry Date</th><td><%= rs.getString("expiry_date") %></td></tr>
            <tr><th>Card Pin</th><td><%= rs.getInt("card_pin") %></td></tr>
            
        </table>
        <%
                } else {
        %>
        <p>No Card found for the given username.</p>
        <a href="CardServlet"><button class="btn btn-warning" >  Apply Debit Card</button></a>
        
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
        %>
        <p>Error retrieving account details. Please try again later.</p>
        <%
            } finally {
                // Close resources
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>
    </div>
     <%   }%>
        

</body>
</html>