package com.znchn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.znchn.entity.User;
import com.znchn.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public User selectUserByNameAndPwd(String username, String password) throws Exception{
		Connection con = JDBCUtil.getConnection();
		String sql = "select * from t_user where username=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			Integer id = rs.getInt("id");
			Integer userType = rs.getInt("userType");
			String status = rs.getString("status");
			Integer positionId = rs.getInt("positionId");
			
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			user.setUserType(userType);
			user.setStatus(status);
			user.setPositionId(positionId);
		} 
		return user;
	}

}
