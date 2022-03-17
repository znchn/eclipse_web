package com.znchn.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/TestHttpServlet", loadOnStartup=1,initParams= {@WebInitParam(name="initName",value="initValue"), @WebInitParam(name="github.com", value="com.znchn")})
public class TestHttpServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println("httpServlet响应========doPost");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("这个是post请求返回");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println("httpServlet响应=========doGet");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("这个是get请求返回");
		
		//获取initParams的数据
		Enumeration<String> en = this.getInitParameterNames();
		while (en.hasMoreElements()) {
			String name = en.nextElement();
			String value = this.getInitParameter(name);
			
			System.out.println("name==" + name + "\t" + "value===" + value);
		}
		
	}
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}
	
	/**
	 * 当配置了loadOnstartup属性，并设置值大于等于0，则服务器启动时就会加载Servlet
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		System.out.println("初始化");
	}
}
