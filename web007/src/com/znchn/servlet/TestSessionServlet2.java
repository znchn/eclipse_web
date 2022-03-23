package com.znchn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestSessionServlet2")
public class TestSessionServlet2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		System.out.println("session==" +  session.getId() + "====" + session.getAttribute("msg"));	//作用于一次会话
		System.out.println("request===msg===" + req.getAttribute("msg"));							//作用于一次请求
		
		session.invalidate();	//销毁session（默认销毁时间是30分钟，可以在tomcat中设置---web.xml）
	}
}
