package com.znchn.entity;

import java.sql.ResultSet;

import com.znchn.entity.mapper.RowMapper;

public class UserMapper implements RowMapper<User>{

	@Override
	public User rowMap(ResultSet rs) throws Exception {
		return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getInt("userType"), rs.getString("status"), rs.getInt("positionId"));
	}

}
