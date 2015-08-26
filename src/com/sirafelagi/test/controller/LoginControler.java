package com.sirafelagi.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginControler {
	
	@RequestMapping(value="/login")
	public String login(){ 
		System.out.println("comes to the security");
		return "login";
	}
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String loginAccept(){ 
//		System.out.println("comes to the security with post");
//		return "login";
//	}

}
