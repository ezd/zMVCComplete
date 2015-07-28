package com.sirafelagi.test.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirafelagi.test.jpa.entities.Blog;
import com.sirafelagi.test.jpa.entities.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	List<Blog> findByUser(User user);
}
