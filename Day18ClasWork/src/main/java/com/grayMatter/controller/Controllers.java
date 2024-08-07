package com.grayMatter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {

	@RequestMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("name","Harsha");
		return "hello";
	}
	
	@RequestMapping("/name")
	public ModelAndView printNamr() {
		ModelAndView mv=new ModelAndView("Harsha");
		
	    String name1="Harsha";
	    mv.addObject("name","Harsha");
		return mv;
	}
	
	
}
