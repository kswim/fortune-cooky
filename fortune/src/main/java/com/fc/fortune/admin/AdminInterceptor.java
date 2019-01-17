package com.fc.fortune.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		
		if(session != null) { 
			Object obj = session.getAttribute("adminId");
		if(obj != null) 
			return true; //세션에 admin값이 존재할 경우 이후 관리자모드로 작업 수행 가능
		}
		
		//세션이 존재하지 않을 때(=관리자 로그인을 하지 않았을 때) /admin으로 리다이렉트 시킴
		response.sendRedirect(request.getContextPath() + "/admin/");
		
		return false; //false일 경우에는 Controller를 수행하지 않음
	}
		
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
		
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		super.afterCompletion(request, response, handler, ex);
	}
		
}
