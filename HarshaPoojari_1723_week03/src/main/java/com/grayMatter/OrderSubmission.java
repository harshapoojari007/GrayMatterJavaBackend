package com.grayMatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderSubmission
 */
public class OrderSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSubmission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		
		
		
		
		Connection con=null;
		PreparedStatement ps=null;
		DriverSourceClass dc=new DriverSourceClass();
		ResultSet rs=null;
		try {
		
			con=dc.getConnection();
			System.out.print("Connection Established");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    String customerName = request.getParameter("customerName");
	        String username = request.getParameter("username");
	        String mobile = request.getParameter("mobile");
	        String email="";
	        int orderId = 0;
	        int customer_id=0;
	        String query="select email from user where username=?";
	        try {
				ps = con.prepareStatement(query);
				ps.setString(1, username);
				rs = ps.executeQuery();
				if (rs.next()) {
				    email = rs.getString(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
	        String query2="insert into customer(name,mobile,order_date,email,username) values(?,?,?,?,?)";
	        
	        try {
				ps = con.prepareStatement(query2);
				ps.setString(1, customerName);
				ps.setString(2, mobile);
				ps.setString(3, "8/2/2024");
				ps.setString(4, email);
				ps.setString(5, username);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
	        
	        String query4="select id from customer where username=?";
	        try {
				ps = con.prepareStatement(query4);
				ps.setString(1, username);
				rs = ps.executeQuery();
				if (rs.next()) {
				    customer_id = rs.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
	        
	        
	        
	        String query3="insert into orders(date,customer_id,total_cost) values(?,?,?)";
	        
	        String[] itemIds = request.getParameterValues("items");
	        double totalCost=0.0;
	        for (String itemId : itemIds) {
                int quantity = Integer.parseInt(request.getParameter("quantity" + itemId));
                double cost = Double.parseDouble(request.getParameter("cost" + itemId));
                totalCost += cost * quantity;
            }
	        
	        try {
				ps = con.prepareStatement(query3);
				ps.setString(3, "8/2/2024");
				ps.setInt(2,customer_id);
				ps.setDouble(3, totalCost);
				ps.executeUpdate();
				  
		        rs = ps.getGeneratedKeys();
	            
	            if (rs.next()) {
	                orderId = rs.getInt(1);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
	       
	        
	        
	        
	      

	        String query5 = "INSERT INTO order_item (order_id, item_id, quantity) VALUES (?, ?, ?)";
            try {
            	
            
	        ps = con.prepareStatement(query5);
            for (String itemId : itemIds) {
                int quantity = Integer.parseInt(request.getParameter("quantity" + itemId));
                if (quantity > 0) {
                    ps.setInt(1, orderId);
                    ps.setInt(2, Integer.parseInt(itemId));
                    ps.setInt(3, quantity);
                    ps.addBatch();
                }
            }
            ps.executeBatch();
            }catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
            
            
            RequestDispatcher dispatcher;
			{
				String alertMessage="Order Successfully Placed";
		        request.setAttribute("alertMessage", alertMessage);
				dispatcher=request.getRequestDispatcher("index.jsp");
			    dispatcher.forward(request, response);
		    }
        






	       
	        
	        
	        
	        
	        
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
