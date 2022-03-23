package com.znchn.dao;

import java.util.ArrayList;
import java.util.List;

import com.znchn.dto.UserDto;
import com.znchn.entity.User;
import com.znchn.entity.UserMapper;
import com.znchn.entity.mapper.UserDtoMapper;
import com.znchn.util.JDBCTemplate;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> selectUserByNameAndPwd(String username, String password) throws Exception{
		JDBCTemplate template = new JDBCTemplate();
		StringBuilder sql = new StringBuilder()
				.append(" select id id, username, password, userType, status, positionId from t_user ")
				.append(" where username=? and password=? ");
		List<User> userList = template.query(sql.toString(), new UserMapper(), username, password);
		return userList;
	}

	@Override
	public List<UserDto> searhAllUser(String searchCont) throws Exception {
		JDBCTemplate template = new JDBCTemplate();
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		StringBuilder sql = new StringBuilder()
				.append(" select a.id id, a.username username, b.positionName positionName from t_user a ")
				.append(" left join t_position b on a.positionId=b.id ");
		if(searchCont != null && searchCont != "") {
			sql.append(" where a.username like ? ");
			userDtoList = template.query(sql.toString(), new UserDtoMapper(), "%" + searchCont + "%");
		}else {
			userDtoList = template.query(sql.toString(), new UserDtoMapper());
		}
		
		return userDtoList;
	}

}
