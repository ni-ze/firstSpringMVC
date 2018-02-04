package com.imooc.mvcdemo.Interceptor1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor   implements HandlerInterceptor{

	 
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("这是afterCompletion!");
	}

	public void postHandle (HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {  
 
		System.out.println("这是 postHandle！");
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		 
		System.out.println("这是preHandle！");
		
 
		
		return true;
	}

}
