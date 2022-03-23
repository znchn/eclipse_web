package com.znchn.service;

import java.util.List;

import com.znchn.dao.UserDao;
import com.znchn.dao.UserDaoImpl;
import com.znchn.dto.UserDto;
import com.znchn.entity.User;

public class UserServiceImpl implements UserService{

	@Override
	public List<User> selectUserByNameAndPwd(String username, String password) throws Exception {
		UserDao userDao = new UserDaoImpl();
		List<User> userList = userDao.selectUserByNameAndPwd(username, password);
		return userList;
	}

	@Override
	public List<UserDto> searhAllUser(String searchCont) throws Exception {
		UserDao userDao = new UserDaoImpl();
		List<UserDto> userDtoList = userDao.searhAllUser(searchCont);
		return userDtoList;
	}

}
