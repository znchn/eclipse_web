package com.znchn.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ddd",urlPatterns="/TestHttpServlet", loadOnStartup=1,initParams= {@WebInitParam(name="initName",value="initValue"), @WebInitParam(name="github.com", value="com.znchn")})
public class TestHttpServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		System.out.println("httpServlet响应========doPost");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("这个是post请求返回");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		System.out.println("httpServlet响应=========doGet");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("这个是get请求返回");
		
		//ServletConfig（Servlet配置信息）
		ServletConfig config = getServletConfig();
		//ServletName默认为当前访问Servlet全路径（com.znchn.util.TestHttpServlet），当注解中配置了name属性之后就是当前配置的信息（ddd）
		System.out.println("ServletName====" + config.getServletName());
		//获取initParams的数据
		Enumeration<String> en = config.getInitParameterNames();	//获取所有参数的名字  返回值  枚举
		while (en.hasMoreElements()) {
			String name = en.nextElement();
			String value = config.getInitParameter(name);			//获取初始化参数的值
			
			System.out.println("name==" + name + "\t" + "value===" + value);
		}
		
		
		//ServletContext（当前项目域对象之一，范围最大，所有Servlet共享）
		ServletContext context = getServletContext();
		System.out.println("context===" + context.getAttribute("msg"));
		
	}
	
	/**
	 * 当配置了loadOnstartup属性，并设置值大于等于0，则服务器启动时就会加载Servlet
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		
		System.out.println("初始化");
	}
}
