package com.znchn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.znchn.dto.UserDto;
import com.znchn.service.UserService;
import com.znchn.service.UserServiceImpl;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String searchCont = req.getParameter("searchCont");
			
			try {
				UserService service = new UserServiceImpl();
				List<UserDto> userDtoList = service.searhAllUser(searchCont);
				req.setAttribute("userDtoList", userDtoList);
				req.setAttribute("searchCont", searchCont);
				req.getRequestDispatcher("/user/search.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
}
