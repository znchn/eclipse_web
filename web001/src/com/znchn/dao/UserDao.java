package com.znchn.dao;

import com.znchn.entity.User;

public interface UserDao {

	User selectUserByNameAndPwd(String username, String password) throws Exception;
}
