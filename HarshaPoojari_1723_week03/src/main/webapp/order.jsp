
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>

<%@page import="java.sql.Connection"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/70562393cb.js" crossorigin="anonymous"></script>
    
</head>
<body style="color: black;">
    <header>
        <div>
            <h1 style="display: block;">FoodFoodie</h1>
        </div>
        <nav>
            <div class="ul">
                <ul type="none">
                <a href="index.jsp"><li>HOME</li></a>
                    <a href="about.jsp"><li>ABOUT US</li></a>
                    
                    <a href=""><li>ORDER NOW</li></a>
                </ul>
            </div>

        </nav>
    </header> 
    
     <div class="container mt-5">
        <header class="mb-4">
            <h1 class="text-center">Order Dashboard</h1>
        </header>
        <form action="OrderSubmission">
            <div class="mb-3">
                <label for="customerName" class="form-label">Customer Name:</label>
                <input type="text" id="customerName" name="customerName" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="username" class="form-label">Username:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="mobile" class="form-label">Mobile:</label>
                <input type="tel" id="mobile" name="mobile" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Select Items:</label>
                <div class="form-check">
                    <%
                        // Fetch items from the database
                        Connection conn = null;
                        Statement stmt = null;
                        ResultSet rs = null;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodDeliveryDB", "root", "password");
                            stmt = conn.createStatement();
                            String sql = "SELECT id, name, cost FROM item";
                            rs = stmt.executeQuery(sql);
                            while (rs.next()) {
                                int itemId = rs.getInt(1);
                                String itemName = rs.getString(2);
                                double itemCost = rs.getDouble(3);
                                
                    %>
                        <div class="list-group-item">
                        <div class="form-check">
                            <input type="checkbox" id="item<%= itemId %>" name="items" value="<%= itemId %>" class="form-check-input">
                            <label for="item<%= itemId %>" class="form-check-label">
                                <%= itemName %> - Rs.<%= String.format("%.2f", itemCost) %>
                            </label>
                        </div>
                        <div class="mt-2">
                                <label for="quantity<%= itemId %>" class="form-label">Quantity:</label>
                                <input type="number" id="quantity<%= itemId %>" name="quantity<%= itemId %>" class="form-control" min="0" value="0">
                                <input type="hidden" name="cost<%= itemId %>" value="<%= String.format("%.2f", itemCost) %>">
                            </div>
                        </div>
                        
                    <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                        }
                    %>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Place your order and Pay now</button>
        </form>
    </div>
    
    
    </body>
</html>