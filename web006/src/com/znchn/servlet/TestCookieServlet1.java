package com.znchn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestCookieServlet1")
public class TestCookieServlet1 extends HttpServlet{
	
	/**
	 * cookie保存在浏览器，用于存放少量信息
	 * 
	 * 当浏览器访问数据库时，服务器会生成一个cookie返回给浏览器
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//添加cookie信息
		Cookie cookie = new Cookie("msg", "123456xx");
		resp.addCookie(cookie);
	}
}
