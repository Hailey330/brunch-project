package com.project.brunch.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.tag.Tag;
import com.project.brunch.service.PostService;
import com.project.brunch.service.crawling.post.NowService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class PostController {

	private final PostRepository postRepository;
	private final PostService postService;
	
	@PostMapping("/post")
	public @ResponseBody String post(@RequestBody Post post) {
		
		postRepository.save(post);
		return "글쓰기 완료";
	}
	
	@GetMapping("/saveposts")
	public String getPosts(NowService nowService) {
		List<Post> posts = null;
		try {
			posts = nowService.getBrunchDatas();
			System.out.println("savePost : " + posts);
			postRepository.saveAll(posts);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "크롤링 포스트 저장 완료";
	}
	
	@PostMapping("/tag")
	public String keyword(@RequestBody Tag tag) {
		return "태그 완료";
	}
	
	@GetMapping("/postlist")
	public List<Post> getPosts(){ // requestDispatcher
		return postService.목록보기();

	}
	
}
