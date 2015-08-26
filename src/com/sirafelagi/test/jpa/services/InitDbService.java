package com.sirafelagi.test.jpa.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sirafelagi.test.jpa.entities.Blog;
import com.sirafelagi.test.jpa.entities.Item;
import com.sirafelagi.test.jpa.entities.Role;
import com.sirafelagi.test.jpa.entities.User;
import com.sirafelagi.test.jpa.repositories.BlogRepository;
import com.sirafelagi.test.jpa.repositories.ItemRepository;
import com.sirafelagi.test.jpa.repositories.RoleRepository;
import com.sirafelagi.test.jpa.repositories.UserRepository;
@Transactional
@Service
public class InitDbService {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BlogRepository blogRepostiory;
	@Autowired
	ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		Role adminRole=new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);
		Role userRole=new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);
		
		User userAdmin=new User();
		userAdmin.setName("admin");
		userAdmin.setEnabled(true);
		BCryptPasswordEncoder bcry=new BCryptPasswordEncoder();
		userAdmin.setPassword(bcry.encode("admin"));
		List<Role> roles=new ArrayList<Role>();
		roles.add(userRole);
		roles.add(adminRole);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blog=new Blog();
		blog.setName("Javavid");
		blog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blog.setUser(userAdmin);
		blogRepostiory.save(blog);
		
		Item item1=new Item();
		item1.setBlog(blog);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2=new Item();
		item2.setBlog(blog);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
	}

}
