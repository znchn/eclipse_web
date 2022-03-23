package com.znchn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

public class JDBCUtil {

	private static DataSource ds;
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	static{
		try {
			Properties properties = new Properties();
			properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			ds = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con = threadLocal.get();
		if(con == null){
			try {
				con = ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			threadLocal.set(con);
		}
		return con;
	}
	
	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
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
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Connection con = JDBCUtil.getConnection();
		System.out.println(con);
		JDBCUtil.closeConnection(con, null, null);
	}
	
	@Test
	public void testConectionByClass() {
		String dirverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/study";
		String user = "root";
		String password = "138139";
		
		try {
			Class.forName(dirverClassName);
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
