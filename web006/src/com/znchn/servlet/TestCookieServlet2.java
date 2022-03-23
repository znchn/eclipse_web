package com.znchn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestCookieServlet2")
public class TestCookieServlet2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取浏览器的cookie信息 
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName() + "====" + cookie.getValue());
			}
		}
	}
}
