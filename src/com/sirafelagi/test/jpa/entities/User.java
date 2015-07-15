package com.sirafelagi.test.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue
int id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

}
