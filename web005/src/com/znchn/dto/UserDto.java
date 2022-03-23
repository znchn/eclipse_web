package com.znchn.dto;

public class UserDto {
	
	private Integer id;
	private String username;
	private String positionName;
	
	public UserDto() {
		
	}

	public UserDto(Integer id, String username, String positionName) {
		super();
		this.id = id;
		this.username = username;
		this.positionName = positionName;
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

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", positionName=" + positionName + "]";
	}
}
