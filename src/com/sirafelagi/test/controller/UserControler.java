package com.sirafelagi.test.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sirafelagi.test.jpa.entities.Blog;
import com.sirafelagi.test.jpa.entities.User;
import com.sirafelagi.test.jpa.services.BlogService;
import com.sirafelagi.test.jpa.services.UserService;

@Controller
public class UserControler {

	@Autowired
	UserService userService;
	
	@Autowired
	BlogService blogService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}

	@ModelAttribute("blog")
	public Blog constructBlog(){
		return new Blog();
	}
	
	
	@RequestMapping("/account")
	public String myAccount(Model model, Principal principal){
		String name=principal.getName();
		model.addAttribute("user", userService.findOneWithBlog(name));
		return "account";
	}
	@RequestMapping(value="/account",method=RequestMethod.POST)
	public String doRegister(Model model,@Valid @ModelAttribute("blog") Blog blog,BindingResult result,Principal principal){
		if(result.hasErrors()){
			return myAccount(model, principal);
		}
		blogService.saveBlog(blog,principal.getName());
		return "redirect:/account.html";
	}
	
	@RequestMapping("/account/remove/{id}")
	public String doRemoveBlog(@PathVariable int id){
		blogService.delete(id);
		return "redirect:/account.html";		
	}
	
}
