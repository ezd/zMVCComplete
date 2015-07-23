package com.sirafelagi.test.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirafelagi.test.jpa.entities.Item;
import com.sirafelagi.test.jpa.entities.User;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
