package com.znchn.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.znchn.entity.User;
import com.znchn.service.UserService;
import com.znchn.service.UserServiceImpl;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setCharEncoding(req, resp);
		
		String username = req.getParameter("username");
		String passsword = req.getParameter("password");
		
		UserService service = new UserServiceImpl();
		try {
			User user = service.selectUserByNameAndPwd(username, passsword);
			if(user != null) {
				if("1".equals(user.getUserType().toString())) {
					resp.sendRedirect("com/znchn/vip/vip.html");
				}else {
					resp.sendRedirect("com/znchn/comm/comm.html");
				}
			}else {
				resp.getWriter().write("登陆失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setCharEncoding(HttpServletRequest req, HttpServletResponse resp){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
	}
}
