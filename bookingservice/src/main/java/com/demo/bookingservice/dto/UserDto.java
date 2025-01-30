package com.demo.bookingservice.dto;



public class UserDto {
	
    private int userid;
    private String fullName;
    private String email;
    private String username;
    private Role role; 
    private boolean active;
    
    public UserDto() {
    	
    }

	public UserDto(int userid, String fullName, String email, String username, Role role, boolean active) {
		super();
		this.userid = userid;
		this.fullName = fullName;
		this.email = email;
		this.username = username;
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
		return "UserDto [userid=" + userid + ", fullName=" + fullName + ", email=" + email + ", username=" + username
				+ ", role=" + role + ", active=" + active + "]";
	}
    
    

}
