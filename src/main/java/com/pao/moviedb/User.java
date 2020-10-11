package com.pao.moviedb;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class User {
	@Id
	private String username;
	private String password;
	@ManyToOne(cascade=CascadeType.MERGE)
	private Role role;
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	protected User(){
		
	}
	User(String username, String password){
		this.username=username;
		this.password=password;
		this.role=new Role("USER");
	}
	
	@Override
	public String toString() {
		return "User{name:"+username+"}";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
	}
}
