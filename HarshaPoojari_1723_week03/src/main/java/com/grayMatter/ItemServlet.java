package com.grayMatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemServlet
 */
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con=null;
		PreparedStatement ps=null;
		DriverSourceClass dc=new DriverSourceClass();
		try {
		
			con=dc.getConnection();
			System.out.print("Connection Established");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String operation = request.getParameter("operation");
		try {
			
		
		if ("add".equals(operation)) {
            // Add new item
            String sql = "insert into item (name, cost) VALUES (?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, request.getParameter("itemName"));
            ps.setDouble(2, Double.parseDouble(request.getParameter("itemCost")));
            ps.executeUpdate();
        } else if ("update".equals(operation)) {
            // Update existing item
            String sql = "update item SET name = ?, cost = ? WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, request.getParameter("newItemName"));
            ps.setDouble(2, Double.parseDouble(request.getParameter("newItemCost")));
            ps.setInt(3, Integer.parseInt(request.getParameter("itemId")));
            ps.executeUpdate();
        } else if ("delete".equals(operation)) {
            // Delete item
            String sql = "delete from item where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(request.getParameter("deleteItemId")));
            ps.executeUpdate();
        }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher;
		{
			String alertMessage="Successfully "+operation+"ed item";;
	        request.setAttribute("alertMessage", alertMessage);
			dispatcher=request.getRequestDispatcher("items.jsp");
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
