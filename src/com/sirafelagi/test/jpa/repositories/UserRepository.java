package com.sirafelagi.test.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirafelagi.test.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}
