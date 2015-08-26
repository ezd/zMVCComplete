package com.sirafelagi.test.jpa.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sirafelagi.test.jpa.entities.Item;
import com.sirafelagi.test.jpa.entities.Role;
import com.sirafelagi.test.jpa.entities.User;
import com.sirafelagi.test.jpa.entities.Blog;
import com.sirafelagi.test.jpa.repositories.BlogRepository;
import com.sirafelagi.test.jpa.repositories.ItemRepository;
import com.sirafelagi.test.jpa.repositories.RoleRepository;
import com.sirafelagi.test.jpa.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	BlogRepository blogRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	RoleRepository roleRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlog(int id) {
		// TODO Auto-generated method stub
		User user=this.findOne(id);
		System.out.println(user.getEmail()+"email");
		List<Blog> blogs=blogRepository.findByUser(user);
		for(Blog blog:blogs){
			List<Item> items=itemRepository.findByBlog(blog,new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void saveUser(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder bcry=new BCryptPasswordEncoder();
		user.setPassword(bcry.encode(user.getPassword()));
		List<Role>roles=roleRepository.findByName("ROLE_USER");
		user.setRoles(roles);
//		userRole.setName("USER_ROLE");
		userRepository.save(user);
	}

	public Object findOneWithBlog(String name) {
		// TODO Auto-generated method stub
		User user=userRepository.findByName(name);
		return findOneWithBlog(user.getId());
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
		
	}

}
