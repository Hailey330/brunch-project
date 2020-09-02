package com.project.brunch.web;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.config.auth.LoginUserAnnotation;
import com.project.brunch.config.auth.dto.LoginUser;
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
	
	// 리액트 Main User뿌리기 / Android 브런치나우 작가목록(태그별)
	@GetMapping("/user")
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

	// 리액트, android 네브 속 유저 정보 / 유저 프로필 편집 (공통)
	@GetMapping("/user/profile")
	public User loginUser(@LoginUserAnnotation LoginUser loginUser) {
		
		System.out.println("UserController : loginUser : " + loginUser.getId());
		userService.로그인유저찾기(loginUser.getId());
		
		User user = User.builder()
				.id(loginUser.getId())
				.bio(loginUser.getBio())
				.nickName(loginUser.getNickName())
				.profileImage(loginUser.getProfileImage())
				.build();
		
		return user;
	}
	
//	@PostMapping("/saveadmin")
//	public String saveAdmin() {
//		List<User> adminUser = null;
//		User admin = User.builder()
//				.email("admin.brunch.co.kr")
//				.profileImage("https://img1.daumcdn.net/thumb/C500x500.fpng/?fname=http://t1.daumcdn.net/brunch/service/user/2xr/image/lylAHyGq9DgVNt5QFKYhQBIYPko.png")
//				.nickName("admin")
//				.userRole(UserRole.ADMIN)
//				.build();
//		adminUser.add(admin);
//		
//		userRepository.saveAll(adminUser);
//		
//		return "어드민 저장완료";
//	}
}
