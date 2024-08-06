package com.grayMatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Connection con=null;
//		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graymatterdb","root","password");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Statement st=null;
		DriverClass dc=new DriverClass();
		try {
			con=dc.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       String query="select * from user";
       try {
    	 
			st=con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			RequestDispatcher dispatcher;
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(3));
				if(rs.getString(1).equals(username) && rs.getString(3).equals(password))
				{
					HttpSession session = request.getSession();
		            session.setAttribute("username", username);
					String alertMessage="Successfully Loggen In";
			        request.setAttribute("alertMessage", alertMessage);
					dispatcher=request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
			}
			dispatcher=request.getRequestDispatcher("ErrorServlet");
			dispatcher.forward(request, response);

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
