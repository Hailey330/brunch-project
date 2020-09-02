package com.project.brunch.config.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.config.handler.exception.MyRoleException;
import com.project.brunch.config.handler.exception.MySessionException;

@ControllerAdvice // IoC 등록됨, Exception을 낚아 채는 컨트롤러
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = MySessionException.class)
	public String sessionException(Exception e) {
		// 인증 안됨
		return "<h1>인증이 없습니다.</h1>";
	} 
	
	@ExceptionHandler(value = MyRoleException.class)
	public String roleException(Exception e) {
		// 권한 없음
		return "<h1>권한이 없습니다.</h1>";
	}
}
