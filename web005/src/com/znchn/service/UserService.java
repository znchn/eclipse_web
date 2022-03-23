package com.znchn.service;

import java.util.List;

import com.znchn.dto.UserDto;
import com.znchn.entity.User;

public interface UserService {

	List<User> selectUserByNameAndPwd(String username, String password) throws Exception;
	List<UserDto> searhAllUser(String searchCont) throws Exception;
}
