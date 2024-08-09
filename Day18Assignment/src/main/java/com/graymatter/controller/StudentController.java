package com.graymatter.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Student;

@Controller
public class StudentController {

	List<Student> sts=new ArrayList<>();
	
	@RequestMapping("/login")
public ModelAndView login(@RequestParam String username, @RequestParam String password) {
	ModelAndView mv=null;
	if(username.equals("admin")&&password.equals("12345"))
	{
		mv=new ModelAndView("StudentDashboard");
		mv.addObject("username",username);
		mv.addObject("alertMessage","Successfully LoggedIn");
		return mv;
	}
	mv=new ModelAndView("login");
	mv.addObject("error","Invalid Credentials");
	return mv;
}
	@RequestMapping("/dologin")	
public ModelAndView dologin() {
		return new ModelAndView("login");
}
	
	@RequestMapping("/addstundent")
	public ModelAndView addform() {
		return new ModelAndView("addStudent");
	}
	
	@RequestMapping("/deletestundent")
	public ModelAndView deleteform() {
		return new ModelAndView("deleteStudent");
	}
	
	@RequestMapping("/getallstundent")
	public ModelAndView getall() {
		return new ModelAndView("getAllStudent");
	}
	
	@RequestMapping("/updatestundent")
	public ModelAndView updateform() {
		return new ModelAndView("updateStudent");
	}
	
	@RequestMapping("/getstundentbyid")
	public ModelAndView getform() {
		return new ModelAndView("getStudentById");
	}
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam String name,@RequestParam String id,@RequestParam String age,@RequestParam String mobile) {
	sts.add(new Student(name,Integer.parseInt(id),Integer.parseInt(age),mobile));
	ModelAndView mv=new ModelAndView("StudentDashboard");
    mv.addObject("alertMessage","Successfully Added Student");
	return mv; 
	}
	
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam String id) {
		int id1=Integer.parseInt(id);
		 Iterator<Student> iterator = sts.iterator();
	        while (iterator.hasNext()) {
	            Student student = iterator.next();
	            if (student.getId() == id1) {
	                iterator.remove();
	                break;
	            }
	        }
	        ModelAndView mv=new ModelAndView("StudentDashboard");
	        mv.addObject("alertMessage","Successfully Deleted Student");
	    	return mv; 
	}
	
	@RequestMapping("/getAll")
	public ModelAndView getAll() {
    ModelAndView mv=new ModelAndView("Display");
    mv.addObject("sts",sts);
    mv.addObject("action", "All");
	return mv;
	}
	
	
	@RequestMapping("/getStudent")
	public ModelAndView getStudent(@RequestParam String id) {
		int id1=Integer.parseInt(id);
		Student sd=null;
		for (Student s : sts) {
			if(s.getId()==id1)
			{
				sd=new Student(s.getName(),id1,s.getAge(),s.getMobile());
				break;
			}
				
		}
		ModelAndView mv=new ModelAndView("Display");
	    mv.addObject("stu",sd);
	    mv.addObject("action", "student");
		return mv;
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam String name,@RequestParam String id,@RequestParam String age,@RequestParam String mobile) {
		int id1=Integer.parseInt(id);
		Student sd=null;
		for (Student s : sts) {
			if(s.getId()==id1)
			{
				
				s.setAge(Integer.parseInt(age));
				s.setMobile(mobile);
				s.setName(name);
				break;
			}
				
		}
		ModelAndView mv=new ModelAndView("StudentDashboard");
        mv.addObject("alertMessage","Successfully Updated Student");
    	return mv; 
	}
	
}
