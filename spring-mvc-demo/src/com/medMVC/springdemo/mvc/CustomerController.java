package com.medMVC.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//add initBiinder to convert trim input strings
	//remove leading and trailing whitespace
	//resolve issue for our validation	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";		
	}
	
	@RequestMapping("/processForm")
	public String processForm(		
		//add validation. data binding
		@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){
		
		System.out.println("Last name: |" + theCustomer.getLastName() + "|" );
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
			return "customer-confirmation";
	}
}
	
	
	

