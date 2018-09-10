package com.beater.springmvc.crud.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecondInterceptor implements HandlerInterceptor {

	/**
	 * preHandle方法在调用目标方法之前调用 
	 *  返回值为false时，不会调用后续的目标方法和拦截器
	 *   使用场景：权限，事务，日志等
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SecondInterceptor[preHandle]");
		return true;
	}
	
	/**
	 * postHandle方法在调用目标方法之后，渲染视图之前调用
	 * 使用场景：修改请求域的属性，视图属性
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SecondInterceptor[postHandle]");
	}
	
	/**
	 * 渲染视图之后调用，用于释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SecondInterceptor[afterCompletion]");
	}

}
