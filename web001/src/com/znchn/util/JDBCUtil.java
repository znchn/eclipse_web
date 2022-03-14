package com.znchn.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil {

	private static DataSource ds;
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	static{
		try {
			Properties properties = new Properties();
			properties.load(JDBCUtil.class.getResourceAsStream("db.properties"));
			ds = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
		}
	}
	
	private static Connection getConnection() {
		Connection con = threadLocal.get();
		if(con == null){
			try {
				con = ds.getConnection();
			} catch (Exception e) {
			}
			threadLocal.set(con);
		}
		return con;
	}
	
	private static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
				threadLocal.remove();
			} 
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args) {
		Connection con = JDBCUtil.getConnection();
		System.out.println(con);
		JDBCUtil.closeConnection(con, null, null);
	}
}
