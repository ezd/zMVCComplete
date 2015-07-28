package com.sirafelagi.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sirafelagi.test.jpa.entities.User;
import com.sirafelagi.test.jpa.services.UserService;

@Controller
public class UserControler {

	@Autowired
	UserService userService;
	
	@RequestMapping("/usersList")
	public String getUsers(Model model){
		List<User> foundUsers=userService.getAllUsers();
		System.out.println("fond at controler"+foundUsers.size());
		model.addAttribute("users", foundUsers);
		return "usersListPage";
	}
	
	@RequestMapping("/users/{id}")
	public String getUsers(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOne(id));
		return "userDetail";
	}
}
