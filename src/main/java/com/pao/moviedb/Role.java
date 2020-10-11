package com.pao.moviedb;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	@Id
	private String name;
	
	@OneToMany(mappedBy="role")
	private List<User> users;
	
	public Role() {
		
	}
	public Role(String name) {
		this.name=name;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
