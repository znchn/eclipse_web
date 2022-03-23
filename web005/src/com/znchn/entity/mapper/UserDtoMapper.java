package com.znchn.entity.mapper;

import java.sql.ResultSet;

import com.znchn.dto.UserDto;

public class UserDtoMapper implements RowMapper<UserDto>{

	@Override
	public UserDto rowMap(ResultSet rs) throws Exception {
		return new UserDto(rs.getInt("id"), rs.getString("username"), rs.getString("positionName"));
	}

}
