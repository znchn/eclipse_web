package com.znchn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestSessionServlet1")
public class TestSessionServlet1 extends HttpServlet{
	
	/**
	 * sesssion是一个域对象，作用范围是一次会话（浏览器从打开到关闭）
	 * 在一个会话中，可以共享数据，用于保存用户相关信息
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("msg", "123");
		req.setAttribute("msg", "456");
		resp.sendRedirect("/web007/TestSessionServlet2");
	}
}
