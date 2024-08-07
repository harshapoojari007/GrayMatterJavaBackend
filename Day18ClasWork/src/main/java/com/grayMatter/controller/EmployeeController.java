package com.grayMatter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grayMatter.model.Employee;

@Controller
//@RequestMapping("/empctrl")
public class EmployeeController {
	
@RequestMapping("/login")
public ModelAndView login(@RequestParam String uname,@RequestParam String password) {
	ModelAndView mv=new ModelAndView("welcome");
	//mv.addObject("uname",uname);
	//return mv;
   if(uname.equals("Harsha")&& password.equals("12345"))
   {
	   mv.addObject("uname",uname);
	   return mv;
   }
   ModelAndView mv1=new ModelAndView("login");
   return mv1;
}
	
@RequestMapping("/employee")
public ModelAndView getEmpInfo() {
	Employee emp=new Employee("Harsha",112,50000000);
	ModelAndView mv=new ModelAndView("emp");
	mv.addObject("emp",emp);
	
	return mv;
}

@RequestMapping("/employee/add")
public ModelAndView addEmployee(@RequestParam String name,@RequestParam String id,@RequestParam String salary) {
	Employee emp=new Employee(name,Integer.parseInt(id),Double.parseDouble(salary));
	ModelAndView mv=new ModelAndView("emp");
	mv.addObject("emp",emp);
	
	return mv;
}


@RequestMapping("/dologin")
public ModelAndView dologin() {
	ModelAndView mv=new ModelAndView("login");
	return mv;
}

@RequestMapping("/addemployee")
public ModelAndView addEmployee() {
	ModelAndView mv=new ModelAndView("addemployee");
	return mv;
}
}
