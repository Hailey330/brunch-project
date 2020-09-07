package com.project.brunch.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.config.auth.LoginUserAnnotation;
import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.service.PostService;
import com.project.brunch.service.UserService;
import com.project.brunch.web.dto.user.UserNavProfileRespDto;
import com.project.brunch.web.dto.user.UserProfileRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch")
@RequiredArgsConstructor
public class UserController {

	private String TAG = "< UserController > ";
	private final UserRepository userRepository;
	private final UserService userService;
	private final PostService postService;

	// [공통] 유저 프로필 정보 뿌리기 - 글 목록 
	@GetMapping("/user/profile/{id}/posts")
	public List<Post> userProfilePosts(@PathVariable int id, @LoginUserAnnotation LoginUser loginUser) {
		List<Post> postEntity = postService.작가의서랍(id);
		return postEntity;
	}

	// [공통] 유저 프로필 정보 뿌리기
	@GetMapping("/user/profile/{id}")
	public UserProfileRespDto userProfile(@PathVariable int id, @LoginUserAnnotation LoginUser loginUser) {
		UserProfileRespDto userProfileRespDto = userService.메인프로필(id, loginUser);
		System.out.println("유저 프로필 정보 확인하기 : " + userProfileRespDto);
		return userProfileRespDto;
	}

	// [로그인] 유저 정보 뿌리기
	@GetMapping("/user/loginUser")
	public UserNavProfileRespDto userNavProfile(@LoginUserAnnotation LoginUser loginUser) {
		UserNavProfileRespDto userNavProfileRespDto = userService.로그인유저찾기(loginUser);
		return userNavProfileRespDto;
	}

	// 로그인한 유저 프로필 업데이트하기
	@PutMapping("/user/profileEdit")
	public User userProfileEdit(@RequestBody Map<String, Object> data, @LoginUserAnnotation LoginUser loginUser) {
		User userEntity = userService.프로필수정하기(data, loginUser);
		return userEntity;
	}

	// 전체 유저 목록 뿌리기
	@GetMapping("/user/list")
	public List<User> userList() {
		return userRepository.findAll();
	}

}
