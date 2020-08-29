package com.project.brunch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.brunch.config.auth.PrincipalDetails;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.service.admin.AdminUserService;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class ViewController {

	
	private static final Logger log = LoggerFactory.getLogger(ViewController.class);

	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final AdminUserService userService;
	
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
