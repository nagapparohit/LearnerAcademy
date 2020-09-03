package com.nagappa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_active")
	private int isActive;
	
	@Column(name = "is_admin")
	private int isAdmin;
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
		

	public UserEntity(int id, String username, String password, int isActive, int isAdmin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", password=" + password + ", isActive=" + isActive
				+ ", isAdmin=" + isAdmin + "]";
	}
	
	
	
	
	
}
