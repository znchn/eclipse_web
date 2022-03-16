package com.znchn.entity;

public class User {

	private Integer id;
	private String username;
	private String password;
	private Integer userType;
	private String status;
	private Integer positionId;
	
	public User(Integer id, String username, String password, Integer userType, String status, Integer positionId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.status = status;
		this.positionId = positionId;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
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
	
	public Integer getUserType() {
		return userType;
	}
	
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getPositionId() {
		return positionId;
	}
	
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ ", status=" + status + ", positionId=" + positionId + "]";
	}
}
