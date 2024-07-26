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
 * Servlet implementation class UserInfoServlet
 */
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		Connection con=null;
		PreparedStatement ps=null;
		DataSourceClass dc=new DataSourceClass();
		try {
		
			con=dc.getConnection();
			System.out.print("Connection Established");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		out.println("Connection Established");
		
		String userid=request.getParameter("userid");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String mobile=request.getParameter("mobile");
		
		String query="insert into user values(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			
			ps.setInt(1, Integer.parseInt(userid));
			ps.setString(2, username);
			ps.setString(4, email);
			ps.setString(3, pwd);
			ps.setString(5, mobile);
		
			ps.executeUpdate();
		RequestDispatcher dispatcher;
//////			if(name.equals("Harsha")&& pwd.equals("12345"))
			{
			request.setAttribute("usernname", username);
				dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
//			else
//			{
//				dispatcher=request.getRequestDispatcher("index.jsp");
//				dispatcher.forward(request, response);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		out.print("Row Inserted Successfully");
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
