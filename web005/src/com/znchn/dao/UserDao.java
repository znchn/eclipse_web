package com.znchn.dao;

import java.util.List;

import com.znchn.dto.UserDto;
import com.znchn.entity.User;

public interface UserDao {

	List<User> selectUserByNameAndPwd(String username, String password) throws Exception;
	List<UserDto> searhAllUser(String searchCont) throws Exception;
}
