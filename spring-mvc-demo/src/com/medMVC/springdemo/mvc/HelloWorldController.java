package com.medMVC.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller to show the form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the html
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//a controller to read form data
	//add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request, Model model) {
		
		//read the req parameter from html form
		String theName = request.getParameter("studentName");
		
		//convert data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Yo! " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//convert data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "What is up? " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}

}
