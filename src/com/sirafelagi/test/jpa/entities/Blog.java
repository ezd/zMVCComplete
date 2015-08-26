package com.sirafelagi.test.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
public class Blog {
	@Id
	@GeneratedValue
	Integer id;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Size(min=2,message="Invalid name, Name must be at least two characters")
	String name;
	@Size(min=1,message="Invalid name, URL must be at least one characters")
	@URL
	String url;
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	@OneToMany(mappedBy="blog",cascade=CascadeType.REMOVE)
	List<Item> items;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
