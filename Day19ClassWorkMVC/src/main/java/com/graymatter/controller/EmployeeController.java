package com.graymatter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Employee;
import com.graymatter.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@RequestMapping("/employee")
	public ModelAndView getAllEmployees(){
		List<Employee> empList=service.getAllEmployee();
	    ModelAndView mv=new ModelAndView("employee");
	   
	    mv.addObject("emp",empList);
	    mv.addObject("action","All");
		return mv;
	}
	
	
	
	

	@RequestMapping("/idEmployee")
	public ModelAndView getEmployee(@RequestParam String id){
		Employee employee=service.getEmployeeById(Integer.parseInt(id));
	    ModelAndView mv=new ModelAndView("employee");
	    mv.addObject("emp", employee);
		return mv;
	}
	

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String username,@RequestParam String password) {
		ModelAndView mv=null;
		if(username.equals("admin") && password.equals("12345"))
		{
			mv=new ModelAndView("EmployeeDashboard");
			mv.addObject("username", username);
			
			return mv;
			
		}
		mv=new ModelAndView("login");
		mv.addObject("error","Invalid Credentials");
		return mv;
			
	}
	
	
	@RequestMapping("/addEmployee")
	public ModelAndView add(@RequestParam String name,@RequestParam String id,@RequestParam String salary) {
		ModelAndView mv=null;
        service.addEmployee(new Employee(name,Integer.parseInt(id),Double.parseDouble(salary)));
        mv=new ModelAndView("EmployeeDashboard");
		mv.addObject("message", "Successfully Added Employee");
			return mv;
		
			
	}
	
	@RequestMapping("/deleteEmployee")
	public ModelAndView delte(@RequestParam String id) {
		ModelAndView mv=null;
        service.deleteEmployee(Integer.parseInt(id));
        mv=new ModelAndView("EmployeeDashboard");
		mv.addObject("message", "Successfully Deleted Employee");
			return mv;
			
	}
	
	@RequestMapping("/updateEmployee")
	public ModelAndView update(@RequestParam String name,@RequestParam String id,@RequestParam String salary) {
		ModelAndView mv=null;
        service.updateEmployee(new Employee(name,Integer.parseInt(id),Double.parseDouble(salary)));
        mv=new ModelAndView("EmployeeDashboard");
		mv.addObject("message", "Successfully Updated Employee");
			return mv;
			
	}
	
	
	
	
	
	
	//Pages Set Up
	
	@RequestMapping("/byid")
	public ModelAndView byId() {
		return new ModelAndView("byid");
	}
	@RequestMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("add");
	}
	@RequestMapping("/delete")
	public ModelAndView delete() {
		return new ModelAndView("delete");
	}
	@RequestMapping("/update")
	public ModelAndView update() {
		return new ModelAndView("update");
	}
	

	@RequestMapping("/dologin")
	public ModelAndView dologin() {
		return new ModelAndView("login");
	}
	
}
