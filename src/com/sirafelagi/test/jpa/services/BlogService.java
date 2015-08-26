package com.sirafelagi.test.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirafelagi.test.jpa.entities.Blog;
import com.sirafelagi.test.jpa.entities.Item;
import com.sirafelagi.test.jpa.entities.User;
import com.sirafelagi.test.jpa.exception.RSSException;
import com.sirafelagi.test.jpa.repositories.BlogRepository;
import com.sirafelagi.test.jpa.repositories.ItemRepository;
import com.sirafelagi.test.jpa.repositories.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired 
	BlogRepository blogRepository;
	@Autowired
	RssService rssService;
	@Autowired
	ItemRepository itemRepository;
	public void saveItem(Blog blog){
		try {
			List<Item>items=rssService.getItems(blog.getUrl());
			for(Item item: items){
				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
				if(savedItem==null){
					item.setBlog(blog);
					itemRepository.save(item);
				}

			}
		} catch (RSSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void saveBlog(Blog blog, String name) {
		User user=userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		saveItem(blog);
		
	}
	
	public void delete(int id) {
		blogRepository.delete(id);
	}

	

}
