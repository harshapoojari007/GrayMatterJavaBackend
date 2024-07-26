package com.grayMatter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		out.print("<html><body bgcolor=cyan><h5>Successfully logged in!</h5></body></html>");
		
		String name=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		RequestDispatcher dispatcher;
		if(name.equals("Harsha")&& pwd.equals("12345"))
		{
			request.setAttribute("uname", name);
			dispatcher=request.getRequestDispatcher("WelcomeServlet");
			dispatcher.forward(request, response);
		}
			
		else
		{
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
