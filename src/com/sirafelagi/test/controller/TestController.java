package com.sirafelagi.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value={"/index","/"})
	public String getIndex(){
		System.out.println("it comes");
		return "index";
	}

}
