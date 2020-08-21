package com.project.brunch.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.config.auth.PrincipalDetails;
import com.project.brunch.domain.tag.Tag;
import com.project.brunch.domain.user.User;
import com.project.brunch.repository.PostRepository;
import com.project.brunch.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class ViewController {

	private final UserRepository userRepository;
	private final PostRepository postRepository;
	
	// 모든 사람이 접근 가능
	@GetMapping("/home")
	public String home() {
		return "연결 성공";
	}
	
	// 모든 사람이 접근 가능
	@PostMapping("/join")
	public String join(@RequestBody User user) {
		
		
		return "회원가입완료";
	}
	
	// 모든 사람이 접근 가능
	@GetMapping("/login")
	public String login() {
		return "로그인 화면";
	}
	
	// Tip : JWT를 사용하면 UserDetailsService를 호출하지 않기 때문에 @AuthenticationPrincipal 사용 불가능.
	// 왜냐하면 @AuthenticationPrincipal은 UserDetailsService에서 리턴될 때 만들어지기 때문이다.
	
	// User만 접근가능
	@GetMapping("/profile")
	public String user(Authentication authentication) {
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
		return "user";
	}
	
	// Admin만 접근가능
	@GetMapping("/admin")
	public List<User> users() {
		return userRepository.findAll(); // 나중에 값 바꿔줘야함
	}
	
	@GetMapping("/tag")
	   public List<Tag> getTag() {
	      return null;
	   }
	
	
}
