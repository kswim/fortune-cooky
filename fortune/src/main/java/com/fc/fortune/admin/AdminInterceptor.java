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
			return true; //���ǿ� admin���� ������ ��� ���� �����ڸ��� �۾� ���� ����
		}
		
		//������ �������� ���� ��(=������ �α����� ���� �ʾ��� ��) /admin���� �����̷�Ʈ ��Ŵ
		response.sendRedirect(request.getContextPath() + "/admin/");
		
		return false; //false�� ��쿡�� Controller�� �������� ����
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
