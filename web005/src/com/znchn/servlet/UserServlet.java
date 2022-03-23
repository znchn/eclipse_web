package com.znchn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.znchn.dto.UserDto;
import com.znchn.entity.User;
import com.znchn.service.UserService;
import com.znchn.service.UserServiceImpl;

@WebServlet("/login")
public class UserServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			try {
				UserService service = new UserServiceImpl();
				List<User> userList = service.selectUserByNameAndPwd(username, password);
				if(userList == null || userList.size() == 0) {
					req.setAttribute("msg", "用户名或密码错误");
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				}else {
					resp.sendRedirect("/web005/user/search.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
}
