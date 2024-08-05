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
 * Servlet implementation class CreateAccountServlet
 */
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
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
	
		//out.println("Connection Established New servlet");
		
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String mobile=request.getParameter("mobile");
		String adhaar=request.getParameter("adhaar");
		String address=request.getParameter("address");
		String account_type=request.getParameter("account_type");
		String card_pin=request.getParameter("card_pin");
		String accountNumber="422201112"+(Math.floor(Math.random())*10000)+"";
		String IFSC="GHP0000422";
		String branch="KUNDAPURA";
		int balance=0;
		int over_draft_limit=0;
		
		if(account_type=="Saving Account") {
			
			over_draft_limit=0;
		}else {
			over_draft_limit=10000;
		}
		
		
		String query="insert into account values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			
			
			ps.setString(1, username);
			ps.setString(2, name);
			ps.setString(3, accountNumber);
			ps.setString(4, IFSC);
			ps.setString(5, branch);
			ps.setString(6, account_type);
			ps.setInt(7, balance);
			ps.setInt(8, over_draft_limit);
			ps.setString(9, mobile);
			ps.setString(10, adhaar);
			ps.setString(11, address);
			ps.setInt(12, Integer.parseInt(card_pin));
		
			ps.executeUpdate();
			out.println("Connection Established");
		RequestDispatcher dispatcher;
			{
				String alertMessage="Successfully Created an Account";
		        request.setAttribute("alertMessage", alertMessage);
				dispatcher=request.getRequestDispatcher("/pages/Accounts.jsp");
			dispatcher.forward(request, response);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
