package com.sirafelagi.test.jpa.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sirafelagi.test.jpa.entities.Blog;
import com.sirafelagi.test.jpa.entities.Item;
import com.sirafelagi.test.jpa.entities.User;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByBlog(Blog blog,Pageable pageable);
	Item findByBlogAndLink(Blog blog,String link);
}
