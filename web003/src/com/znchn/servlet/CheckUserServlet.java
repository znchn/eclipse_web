package com.znchn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String referer = req.getHeader("referer");
		System.out.println("referer===" + referer);
		if(referer.indexOf("vip.html") > -1) {
			req.getRequestDispatcher("com/znchn/vip/watch-movie.html").forward(req, resp);
		}else {
			req.getRequestDispatcher("com/znchn/comm/rechange.html").forward(req, resp);
		}
	}
}
