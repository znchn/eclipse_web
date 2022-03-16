package com.znchn.service;

import com.znchn.entity.User;

public interface UserService {

	User selectUserByNameAndPwd(String username, String password) throws Exception;
}
