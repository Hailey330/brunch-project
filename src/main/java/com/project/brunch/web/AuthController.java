package com.project.brunch.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.brunch.config.auth.PrincipalDetails;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") 
@RequiredArgsConstructor 
public class AuthController {
	
	// 모든 사람이 접근 가능
	@GetMapping("/")
	public String home() {
		return "연결 성공";
	}
	
	// 모든 사람이 접근 가능
	@GetMapping("/login")
	public String login() {
		return "로그인 화면";
	}
	
	// User만 접근가능
	@GetMapping("/profile")
	public String user(Authentication authentication) {
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
		return "user";
	}
}
