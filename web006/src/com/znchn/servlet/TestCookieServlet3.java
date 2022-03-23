package com.znchn.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.znchn.util.CookieUtil;

@WebServlet("/TestCookieServlet3")
public class TestCookieServlet3 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取浏览器的cookie信息 
		Cookie[] cookies = req.getCookies();
		Cookie cookie = CookieUtil.getCookieByName(cookies, "last_time");
		String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(cookie != null) {
			cookie.setValue(currentTime);
			resp.addCookie(cookie);
		}else {
			cookie = new Cookie("last_time", currentTime);
			resp.addCookie(cookie);
		}
		resp.getWriter().write(cookie.getValue());
	}
}
