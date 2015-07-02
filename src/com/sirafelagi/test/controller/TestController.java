package com.sirafelagi.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/index")
	public String getIndex(){
		return "/WEB-INF/jsp/index.jsp";
	}

}
