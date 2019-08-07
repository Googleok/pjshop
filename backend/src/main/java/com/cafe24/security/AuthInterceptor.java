package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.pjshop.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception{
		// 1. handler ���� Ȯ��
		// ������ �ΰ���  HandlerMethod, DefaultServletHandler
		// handlermethod�� �ƴ� assets �� image ���ϵ��� interceptor�� �ɸ��� �ʰ� �������ִ� ��
		if(handler instanceof HandlerMethod == false ) {
			return true;
		}
		
		// 2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		// 3. Method�� @Auth �޾ƿ���
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		// 4. method�� @Auth�� ���� ���, �� ������ �ʿ� ���� ��û
		if(auth == null) {
			return true;
		}
		
		// 5. @Auth�� �ִ� ����̹Ƿ�, ������ �ִ��� üũ
		HttpSession session = request.getSession();
		if(session == null) {
			// �α��� ȭ������ �̵�
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		// 6. ������ �����ϸ� ��ȿ�� �������� Ȯ��
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		// 7. admin�� ���
		String role = auth.role().toString();
		if("ROLE_ADMIN".equals(role)) {
			// admin���� �� �� �ִ� ������ �ۼ��Ѵ�.
			// ex ) ������ id�� admin�̸� admin�̴�.
			if("admin".equals(authUser.getId()) == false) {
				response.sendRedirect(request.getContextPath());
				return false;
			}
		}

		// 8. �����㰡, �� �޼��带 �����ϵ��� ��
		return true;
	}
}
