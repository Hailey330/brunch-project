package com.project.brunch.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.config.auth.LoginUserAnnotation;
import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") 
@RequiredArgsConstructor 
public class PostController {

	private final PostRepository postRepository;
	private final PostService postService;

	// 로그인한 유저의 포스팅 저장하기
	@PostMapping("/post/save")
	public @ResponseBody Post postSave(@RequestBody Post post, @LoginUserAnnotation LoginUser loginUser) {
		return postRepository.save(post);
	}

	// 포스팅 전체 목록 뿌리기
	@GetMapping("/post/list")
	public List<Post> postList() {
		return postRepository.findAll();
	}

	// By_민경
	// 포스팅 메인 페이지 Dto 뿌리기
	// 안드로이드 주소 맞추기 main/post -> post/main
	@GetMapping("/post/main")
	public List<Post> postMain() {
		return postService.메인목록();
	}

}
