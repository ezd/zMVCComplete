package com.sirafelagi.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sirafelagi.test.jpa.entities.User;
import com.sirafelagi.test.jpa.services.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {
	@Autowired
	UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping("/usersList")
	public String getUsers(Model model){
		List<User> foundUsers=userService.getAllUsers();
		System.out.println("fond at controler"+foundUsers.size());
		model.addAttribute("users", foundUsers);
		return "usersListPage";
	}
	
	//@RequestMapping("/users/{id}")
	public String getUsers(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOne(id));
		return "userDetail";
	}
	@RequestMapping("/{id}")
	public String getUsersNoProxy(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlog(id));
		return "userDetail";
	}
	@RequestMapping("/remove/{id}")
	public String doRemoveUser(@PathVariable int id){
		userService.delete(id);
		return "redirect:/usersList.html";		
	}

}
