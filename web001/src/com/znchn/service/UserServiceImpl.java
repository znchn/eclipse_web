package com.znchn.service;

import com.znchn.dao.UserDao;
import com.znchn.dao.UserDaoImpl;
import com.znchn.entity.User;

public class UserServiceImpl implements UserService{

	@Override
	public User selectUserByNameAndPwd(String username, String password) throws Exception {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.selectUserByNameAndPwd(username, password);
		return user;
	}

}
