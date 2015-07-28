package com.sirafelagi.test.jpa.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirafelagi.test.jpa.entities.Item;
import com.sirafelagi.test.jpa.entities.User;
import com.sirafelagi.test.jpa.entities.Blog;
import com.sirafelagi.test.jpa.repositories.BlogRepository;
import com.sirafelagi.test.jpa.repositories.ItemRepository;
import com.sirafelagi.test.jpa.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	BlogRepository blogRepository;
	@Autowired
	ItemRepository itemRepository;
	
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
		User user=findOne(id);
		List<Blog> blogs=blogRepository.findByUser(user);
		for(Blog blog:blogs){
			List<Item> items=itemRepository.findByBlog(blog);
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return null;
	}

}
