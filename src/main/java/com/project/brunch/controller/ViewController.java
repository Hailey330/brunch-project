package com.project.brunch.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.brunch.config.auth.PrincipalDetails;
import com.project.brunch.repository.PostRepository;
import com.project.brunch.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class ViewController {

	private final UserRepository userRepository;
	private final PostRepository postRepository;
	
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
	
	@GetMapping("/admin")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/admin/user")
	public String userForm() {
		return "user";
	}
	
	@GetMapping("/admin/post")
	public String postForm() {
		return "post";
	}	
	
	@GetMapping("/admin/main")
	public String adminMainForm() {
		return "main";
	}	
	
	@GetMapping("/admin/comment")
	public String admincommentForm() {
		return "comment";
	}	
}
