package com.znchn.service;

import com.znchn.dao.UserDao;
import com.znchn.dao.UserDaoImpl;
import com.znchn.entity.User;

public class UserServiceImpl implements UserService{

	@Override
	public User selectUserByNameAndPwd(String username, String passsword) throws Exception {
		UserDao dao = new UserDaoImpl();
		return dao.selectUserByNameAndPwd(username, passsword);
	}

}
