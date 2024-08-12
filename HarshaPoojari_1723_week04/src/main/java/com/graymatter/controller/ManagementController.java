package com.graymatter.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Customer;
import com.graymatter.model.Order;
import com.graymatter.model.User;
import com.graymatter.service.CustomerService;
import com.graymatter.service.OrderService;
import com.graymatter.service.UserService;

@Controller
public class ManagementController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	
	//Pages Rendering
	  @PostMapping("/logout")
	    public String logout(HttpServletRequest request) {
	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate(); // Invalidate the session
	        }
	        return "redirect:/dologin"; // Redirect to login page or another page
	    }
	
	
	
	//Welcome
		@RequestMapping("/welcome")
		public String welcome() {
			return "Welcome";
			
		}
	
    //1.Login
	@RequestMapping("/dologin")
	public String dologin() {
		return "login";
		
	}
	//2.Sign Up
	@RequestMapping("/dosignup")
	public String dosignup() {
		return "signup";
		
	}
	//3.Customer Dashboard
	@RequestMapping("/doCustomerDashboard")
	public String doCustDashboard() {
		return "CustomerDashboard";
		
	}
	//4.Order Dashboard
	@RequestMapping("/doOrderDashboard")
	public String doOrdDashbaord() {
		return "OrderDashboard";
		
	}
	
	//5. Add Customer
	@RequestMapping("/doAddCustomer")
	public ModelAndView doAddCustomer() {
		ModelAndView mv=new ModelAndView("CustomerDashboard");
		mv.addObject("action","addCustomer");
		return mv;
	}
	
	//6. Delete Customer
	@RequestMapping("/doDeleteCustomer")
	public ModelAndView doDeleteCustomer() {
		ModelAndView mv=new ModelAndView("CustomerDashboard");
		mv.addObject("action","deleteCustomer");
		return mv;
	}
	
	//7. Update Customer
	@RequestMapping("/doUpdateCustomer")
	public ModelAndView doUpdateCustomer() {
		ModelAndView mv=new ModelAndView("CustomerDashboard");
		mv.addObject("action","updateCustomer");
		return mv;
	}
	//8. Get All
	@RequestMapping("/doGetCustomer")
	public ModelAndView doGetCustomer() {
		ModelAndView mv=new ModelAndView("CustomerDashboard");
		mv.addObject("action","getCustomer");
		return mv;
	}
	
	//8. Get All
		@RequestMapping("/doAddOrder")
		public ModelAndView doAddOrder() {
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("action","addOrder");
			return mv;
		}
		
		@RequestMapping("/doDeleteOrder")
		public ModelAndView doDeleteOrder() {
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("action","deleteOrder");
			return mv;
		}
		@RequestMapping("/doUpdateOrder")
		public ModelAndView doUpdateOrder() {
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("action","updateOrder");
			return mv;
		}
	
		@RequestMapping("/doGetOrder")
		public ModelAndView doGetOrder() {
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("action","getOrder");
			return mv;
		}
	
		@RequestMapping("/doGetOrderCustomer")
		public ModelAndView doGetOrderCustomer() {
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("action","getOrderCustomer");
			return mv;
		}
	
	
	
	
	
	
	//User Services
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String username,@RequestParam String password,HttpSession session) {
		ModelAndView mv=null;
		List<User> u=userService.getUser(username, password);
		if(u.isEmpty())
		{
			mv=new ModelAndView("login");
			mv.addObject("error","Invalid Credentials");
			return mv;
		}

		mv=new ModelAndView("Welcome");
		
		session.setAttribute("username", username);	
		session.setAttribute("role", u.get(0).getRole());	
		return mv;
		
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup(@RequestParam String username,@RequestParam String email, @RequestParam String password,@RequestParam String role) {
		ModelAndView mv=null;
		int i=userService.addUser(new User(username,email,password,role));
		if(i==1) {
			mv=new ModelAndView("login");
			return mv;
		}
		mv=new ModelAndView("signup");
		mv.addObject("error","Username Already exists");
		return mv;
			
	}
	
	
	
	//Customer Services
	//ADD
	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer(@RequestParam String id, @RequestParam String name, @RequestParam String email, HttpSession session) {
		String username=(String)session.getAttribute("username");
		int i=customerService.addCustomer(new Customer(Integer.parseInt(id),name,email),username);
		ModelAndView mv=new ModelAndView("CustomerDashboard");
		mv.addObject("message","Successfully Added Customer");
		mv.addObject("function","add");
		return mv;
	}
	//DELETE
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(@RequestParam String id,HttpSession session) {
		String username=(String)session.getAttribute("username");
		int i=customerService.deleteCustomer(Integer.parseInt(id));
		ModelAndView mv=new ModelAndView("CustomerDashboard");
		mv.addObject("message","Successfully Deleted Customer");
		mv.addObject("function","delete");
		return mv;
	}
	//UPDATE
	@RequestMapping("/updateCustomer")
	public ModelAndView updateCustomer(@RequestParam String id, @RequestParam String name, @RequestParam String email, HttpSession session) {
		String username=(String)session.getAttribute("username");
		int i=customerService.updateCustomer(new Customer(Integer.parseInt(id),name,email));
		ModelAndView mv=new ModelAndView("CustomerDashboard");
		mv.addObject("message","Successfully Updated Customer");
		mv.addObject("function","update");
		return mv;
	}
	//GET
	@RequestMapping("/getCustomer")
	public ModelAndView getCustomer(@RequestParam String id, HttpSession session) {
		String username=(String)session.getAttribute("username");
		Customer c=customerService.getCustomerById(Integer.parseInt(id));
		ModelAndView mv=new ModelAndView("CustomerDashboard");
		mv.addObject("customer",c);
		mv.addObject("function","getCustomer");
		return mv;
	}
	//GET ALL
	@RequestMapping("/getAllCustomer")
	public ModelAndView getAllCustomer(HttpSession session) {
		String username=(String)session.getAttribute("username");
		List<Customer> cl=customerService.getAllCustomer();
		ModelAndView mv=new ModelAndView("CustomerDashboard");
		mv.addObject("customerList",cl);
		mv.addObject("function","getAllCustomer");
		return mv;
	}
	
	//ORDER SERVICES
	//ADD
		@RequestMapping("/addOrder")
		public ModelAndView addOrder(@RequestParam String id,@RequestParam String totalAmount,@RequestParam String customerId, HttpSession session) throws ParseException {
			LocalDate localDate = LocalDate.now();
	        Date sqlDate = Date.valueOf(localDate);
            
			int i=orderService.addOrder(new Order(Integer.parseInt(id),sqlDate,Double.parseDouble(totalAmount),Integer.parseInt(customerId)));
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("message","Successfully Added Order");
			mv.addObject("function","add");
			return mv;
		}
		//DELETE
		@RequestMapping("/deleteOrder")
		public ModelAndView deleteOrder(@RequestParam String id,HttpSession session) {
			String username=(String)session.getAttribute("username");
			int i=orderService.deleteOrder(Integer.parseInt(id));
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("message","Successfully Deleted Order");
			mv.addObject("function","delete");
			return mv;
		}
		//UPDATE
		@RequestMapping("/updateOrder")
		public ModelAndView updateOrder(@RequestParam String id,@RequestParam String totalAmount,@RequestParam String customerId, HttpSession session) throws ParseException {
			LocalDate localDate = LocalDate.now();
	        Date sqlDate = Date.valueOf(localDate);
            
			int i=orderService.updateOrder(new Order(Integer.parseInt(id),sqlDate,Double.parseDouble(totalAmount),Integer.parseInt(customerId)));
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("message","Successfully Updated Order");
			mv.addObject("function","update");
			return mv;
		}
		//GET
		@RequestMapping("/getOrder")
		public ModelAndView getOrder(@RequestParam String id, HttpSession session) {
			String username=(String)session.getAttribute("username");
			Order o=orderService.getOrderById(Integer.parseInt(id));
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("order",o);
			mv.addObject("function","getOrder");
			return mv;
		}
		//GET ALL
		@RequestMapping("/getAllOrder")
		public ModelAndView getAllOrder(HttpSession session) {
			String username=(String)session.getAttribute("username");
			List<Order> ol=orderService.getAllOrder();
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("orderList",ol);
			mv.addObject("function","getAllOrder");
			return mv;
		}
		
		@RequestMapping("/getOrderCustomer")
		public ModelAndView getOrderCustomer(@RequestParam String id,HttpSession session) {
			String username=(String)session.getAttribute("username");
			List<Order> ol=orderService.getOrderByCustomer(Integer.parseInt(id));
			ModelAndView mv=new ModelAndView("OrderDashboard");
			mv.addObject("orderList",ol);
			mv.addObject("action", "getCustomerOrder");
			mv.addObject("function","getCustomerOrder");
			return mv;
		}
	
	
	
	
	
	
}
