package com.znchn.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ��");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		res.setCharacterEncoding("UTF-8");
		
		
		// TODO Auto-generated method stub
		System.out.println("servlet����");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username==" + username);
		System.out.println("password==" + password);
		
		String retStr = login(username, password);
		
		res.getWriter().write(retStr);
	}

	public String login(String username, String password) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select count(1) from user where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return "��¼�ɹ�";
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "��½ʧ��";
	}
}
