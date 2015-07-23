package com.sirafelagi.test.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirafelagi.test.jpa.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
