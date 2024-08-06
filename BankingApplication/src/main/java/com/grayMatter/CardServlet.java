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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CardServlet
 */
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardServlet() {
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
		DriverClass dc=new DriverClass();
		try {
			con=dc.getConnection();
			System.out.print("Connection Established");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    		
		 HttpSession session1 = request.getSession(false); // false means do not create a new session if one doesn't exist
	        String username = (session1 != null) ? (String) session1.getAttribute("username") : null;
    		
    		String card_no = "4222 8767 1232 " + String.format("%04d", (int)(Math.random() * 10000));

    		String cvv="" + String.format("%03d", (int)(Math.random() * 1000));
    		String card_pin="" + String.format("%04d", (int)(Math.random() * 10000));
    		String expiry_date="06/31";
    		
    		
    		String query="insert into card values(?,?,?,?,?)";
    		try {
    			ps=con.prepareStatement(query);
    			ps.setString(1, username);
    			ps.setString(2, card_no);
    			ps.setInt(3, Integer.parseInt(card_pin));
    			ps.setString(4, cvv);
    			ps.setString(5, expiry_date);
    		   
    		
    			ps.executeUpdate();
    			out.println("Connection Established");
    		RequestDispatcher dispatcher;
    	    {
    				String alertMessage="Successfully Created a Debit Card";
    		        request.setAttribute("alertMessage", alertMessage);
    				dispatcher=request.getRequestDispatcher("Cards.jsp");
    			dispatcher.forward(request, response);
    		}
    		} catch (SQLException e) {
    			e.printStackTrace();
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
