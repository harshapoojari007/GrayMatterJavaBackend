
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

 <script type="text/javascript">
        function showAlert(message) {
            if (message) {
                alert(message);
            }
        }
    </script>


<body style="color: black;" style="background-color: rgb(202, 200, 198);" onload="showAlert('<%= request.getAttribute("alertMessage") != null ? request.getAttribute("alertMessage") : "" %>')">
    <header>
        <div>
            <h1 style="display: block;">FoodFoodie</h1>
        </div>
        <nav>
            <div class="ul">
                <ul type="none">
                <a href="index.jsp"><li>HOME</li></a>
                    <a href="about.jsp"><li>ABOUT US</li></a>
                    <a href=""><li>ITEMS</li></a>

                </ul>
            </div>

        </nav>
        <div class="loginbtn">
            <a href="login.jsp"> LOGIN </a>
        </div>
    </header> 
    
         <div class="container mt-5">
        <h1 class="text-center">Items Management</h1>


        <h2>Items List</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Cost</th>
                </tr>
            </thead>
            <tbody>
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
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            double cost = rs.getDouble("cost");
                %>
                <tr>
                    <td><%= id %></td>
                    <td><%= name %></td>
                    <td><%= String.format("%.2f", cost) %></td>
                </tr>
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
            </tbody>
        </table>
       
        <div class="mb-4">
            <h2>Add New Item</h2>
            <form action="ItemServlet" method="post">
                <input type="hidden" name="operation" value="add">
                <div class="mb-3">
                    <label for="itemName" class="form-label">Item Name:</label>
                    <input type="text" id="itemName" name="itemName" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="itemCost" class="form-label">Item Cost:</label>
                    <input type="number" id="itemCost" name="itemCost" class="form-control" step="0.01" required>
                </div>
                <button type="submit" class="btn btn-primary">Add Item</button>
            </form>
        </div>

   
        <div class="mb-4">
            <h2>Update Item</h2>
            <form action="ItemServlet" method="post">
                <input type="hidden" name="operation" value="update">
                <div class="mb-3">
                    <label for="itemId" class="form-label">Item ID:</label>
                    <input type="number" id="itemId" name="itemId" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="newItemName" class="form-label">New Item Name:</label>
                    <input type="text" id="newItemName" name="newItemName" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="newItemCost" class="form-label">New Item Cost:</label>
                    <input type="number" id="newItemCost" name="newItemCost" class="form-control" step="0.01" required>
                </div>
                <button type="submit" class="btn btn-primary">Update Item</button>
            </form>
        </div>

    
        <div class="mb-4">
            <h2>Delete Item</h2>
            <form action="ItemServlet" method="post">
                <input type="hidden" name="operation" value="delete">
                <div class="mb-3">
                    <label for="deleteItemId" class="form-label">Item ID:</label>
                    <input type="number" id="deleteItemId" name="deleteItemId" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-danger">Delete Item</button>
            </form>
        </div>

       
        
    </div>
    
    
    </body>
</html>