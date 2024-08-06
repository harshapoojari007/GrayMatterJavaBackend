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
 * Servlet implementation class AccountOperations
 */
public class AccountOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountOperations() {
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
		
        String action=request.getParameter("action");
        HttpSession session1 = request.getSession(false); // false means do not create a new session if one doesn't exist
        String username = (session1 != null) ? (String) session1.getAttribute("username") : null;
        
        if(action.equals("createAccount"))
        {
    		String name=request.getParameter("name");
    		
    		String mobile=request.getParameter("mobile");
    		String adhaar=request.getParameter("adhaar");
    		String address=request.getParameter("address");
    		String account_type=request.getParameter("account_type");
    		String card_pin=request.getParameter("card_pin");
    		String accountNumber = "422201112" + String.format("%04d", (int)(Math.random() * 10000));

    		String IFSC="GHP0000422";
    		String branch="KUNDAPURA";
    		int balance=0;
    		int over_draft_limit=0;
    		
    		if(account_type.equals("Saving Account")) {
    			
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
    				dispatcher=request.getRequestDispatcher("Accounts.jsp");
    			dispatcher.forward(request, response);
    		}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
        }else if(action=="deleteAccount") {
        	
        	String accountNumber=request.getParameter("accountNumber");
        	String query="delete from account where username=? and accountNumber=?";
        	try {
				ps=con.prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, accountNumber);
				ps.executeUpdate();
				
				RequestDispatcher dispatcher;
	    	    {
	    				String alertMessage="Successfully Deleted an Account";
	    		        request.setAttribute("alertMessage", alertMessage);
	    				dispatcher=request.getRequestDispatcher("Accounts.jsp");
	    			    dispatcher.forward(request, response);
	    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }else if(action=="addMoney")
        {
        	
        	String accountNumber=request.getParameter("accountNumber");
        	String amount=request.getParameter(amount);
        	String query="Update account SET balance=? where accountNumber=?";
        	try {
				ps=con.prepareStatement(query);
				ps.setString(1, amount);
				ps.setString(2, accountNumber);
				ps.executeUpdate();
				
				RequestDispatcher dispatcher;
	    	    {
	    				String alertMessage="Successfully Added Amount";
	    		        request.setAttribute("alertMessage", alertMessage);
	    				dispatcher=request.getRequestDispatcher("Accounts.jsp");
	    			    dispatcher.forward(request, response);
	    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        else if(action=="updateAccount") {
        	
        	String accountNumber=request.getParameter("accountNumber");
        	String query="delete from account where username=? and accountNumber=?";
        	try {
				ps=con.prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, accountNumber);
				ps.executeUpdate();
				
				RequestDispatcher dispatcher;
	    	    {
	    				String alertMessage="Successfully Deleted an Account";
	    		        request.setAttribute("alertMessage", alertMessage);
	    				dispatcher=request.getRequestDispatcher("/pages/Accounts.jsp");
	    			    dispatcher.forward(request, response);
	    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if(action=="updatePin")
        {
        	
        	String card_pin=request.getParameter("card_pin");
        	String query="update card SET card_pin=? where username=?";
        	try {
				ps=con.prepareStatement(query);
				ps.setString(2, username);
				ps.setInt(1, Integer.parseInt(card_pin));
				ps.executeUpdate();
				
				RequestDispatcher dispatcher;
	    	    {
	    				String alertMessage="Successfully Updated the Pin";
	    		        request.setAttribute("alertMessage", alertMessage);
	    				dispatcher=request.getRequestDispatcher("Accounts.jsp");
	    			    dispatcher.forward(request, response);
	    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if(action=="withdraw") {
        	
        	//String
        	String query="update account SET balance=? where username=?";
        	try {
				ps=con.prepareStatement(query);
				ps.setString(2, username);
				ps.setString(1, username);
				ps.executeUpdate();
				
				RequestDispatcher dispatcher;
	    	    {
	    				String alertMessage="Successfully Deleted an Account";
	    		        request.setAttribute("alertMessage", alertMessage);
	    				dispatcher=request.getRequestDispatcher("/pages/Accounts.jsp");
	    			    dispatcher.forward(request, response);
	    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if(action=="addMoney")
        {
        	String username=request.getParameter("username");
        	String accountNumber=request.getParameter("accountNumber");
        	String query="delete from account where username=? and accountNumber=?";
        	try {
				ps=con.prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, accountNumber);
				ps.executeUpdate();
				
				RequestDispatcher dispatcher;
	    	    {
	    				String alertMessage="Successfully Deleted an Account";
	    		        request.setAttribute("alertMessage", alertMessage);
	    				dispatcher=request.getRequestDispatcher("/pages/Accounts.jsp");
	    			    dispatcher.forward(request, response);
	    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
