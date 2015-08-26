package com.sirafelagi.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sirafelagi.test.jpa.entities.User;
import com.sirafelagi.test.jpa.services.BlogService;
import com.sirafelagi.test.jpa.services.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping("/register")
	public String register(){
		return "userRegister";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user,BindingResult result){
		if(result.hasErrors()){
			return "userRegister";
		}
		userService.saveUser(user);
		return "redirect:/register.html?success=true";
	}
}
