package com.znchn.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBCConnection {

	public static void main(String[] args) throws Exception{
		Connection con = JDBCUtil.getConnection();
		String sql = "select id, name from city";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			System.out.println("id=" + id + "，  name=" + name);
		}
		JDBCUtil.closeConnection(con, ps, rs);
	}
}
