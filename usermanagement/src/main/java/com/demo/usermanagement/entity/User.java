package com.demo.usermanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@Column(nullable = false)
	private String fullName;
    @Column(nullable = false)
    private String email; 
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private boolean active = true; 
	
	
	public User() {
		
	}


	public User(int userid, String fullName, String email, String username, String password, Role role,
			boolean active) {
		super();
		this.userid = userid;
		this.fullName = fullName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", fullName=" + fullName + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", role=" + role + ", active=" + active + "]";
	}
	
	

}
