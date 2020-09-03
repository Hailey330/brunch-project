package com.project.brunch.config.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.brunch.config.handler.exception.MyRoleException;
import com.project.brunch.config.handler.exception.MySessionException;
import com.project.brunch.domain.user.User;

public class RoleInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("관리자페이지는 인증과 권한을 체크해야한다.");
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		
		if (principal == null) {
			System.out.println("RoleInterceptor : 인증이 되지 않았습니다.");
			throw new MySessionException();
		} else {
//			if (!principal.getRole().equals("ROLE_ADMIN")) {
//				System.out.println("RoleIntercepter : 권한이 없습니다.");
//				throw new MyRoleException();
			}
//		}
		
		return true;
	}

	
}
