package com.project.brunch.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public @ResponseBody String postSave(@RequestBody Post post, @LoginUserAnnotation LoginUser loginUser) {
		postService.글저장(post, loginUser);
		return "글 저장에 성공했습니다.";
	}

	// 작가의 서랍 글 목록 뿌리기
	@GetMapping("/post/writer")
	public List<Post> getWriterPost(@LoginUserAnnotation LoginUser loginUser) {
		return postService.작가의서랍(loginUser.getId());
	}

	// 태그별 글 목록 뿌리기
	@GetMapping("/post/list/{tag}")
	public List<Post> getTagPostList(@PathVariable String tag) {
		return postService.태그별글목록(tag);
	}

	// 포스팅 전체 목록 뿌리기
	@GetMapping("/post/list")
	public List<Post> postList() {
		return postRepository.findAll();
	}

	// 포스팅 메인 페이지 Dto 뿌리기
	// 안드로이드 주소 맞추기 main/post -> post/main
	@GetMapping("/post/main")
	public List<Post> postMain() {
		return postService.메인목록();
	}

}
