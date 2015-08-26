package com.sirafelagi.test.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirafelagi.test.jpa.entities.Role;
import com.sirafelagi.test.jpa.entities.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	List<Role> findByName(String name);

}
