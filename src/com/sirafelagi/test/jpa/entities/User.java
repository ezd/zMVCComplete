package com.sirafelagi.test.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.websocket.ClientEndpoint;

import org.hibernate.validator.constraints.Email;

import com.sirafelagi.test.anotations.UniqueUsername;

@Entity
@Table(name="app_user")
public class User {
@Id
@GeneratedValue
Integer id;
@Size(min=2,message="Invalid name, Name must be at least two characters")
@Column(unique=true)
@UniqueUsername(message="The username already exists")
String name;
boolean  enabled;
public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
@Email(message="Invalid email. ex example@example.exampl")
String email;
@Size(min=6,message="Invalid password, Password must be at least 6 characters")
String password;
@ManyToMany
@JoinTable
List<Role> roles;
@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
List<Blog> blogs;



public List<Blog> getBlogs() {
	return blogs;
}

public void setBlogs(List<Blog> blogs) {
	this.blogs = blogs;
}

public List<Role> getRoles() {
	return roles;
}

public void setRoles(List<Role> roles) {
	this.roles = roles;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

}
