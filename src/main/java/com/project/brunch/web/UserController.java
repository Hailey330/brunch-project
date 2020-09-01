package com.project.brunch.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.service.UserService;
import com.project.brunch.service.crawling.user.NowCrawling;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class UserController {
	
	private final UserRepository userRepository;
	private final UserService userService;
	
	// 메인페이지 user정보 뿌리기 
	@GetMapping("user")
	public List<User> homeUser() {
		
		return userService.목록보기();
	}
	
	@GetMapping("/saveuser")
	@ResponseBody
	public String saveUser(NowCrawling nowCrawling) {
		List<User> users = null;
		try {
			users = nowCrawling.getNowCrawling();
			System.out.println("saveUser : "+users);
			userRepository.saveAll(users);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "유저 저장완료";
	}

	@PostMapping("/user/{email}")
	public User loginUser(@PathVariable String email) {
		
		return userService.로그인유저찾기(email);
	}
	
//	@PostMapping("/saveadmin")
//	public String saveAdmin() {
//		List<User> adminUser = User.builder()
//				
//	}
}
