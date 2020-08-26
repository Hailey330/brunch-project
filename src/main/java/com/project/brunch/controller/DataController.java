package com.project.brunch.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.tag.Tag;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.service.admin.UserService;
import com.project.brunch.service.crawling.post.NowService;
import com.project.brunch.service.crawling.user.NowCrawling;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class DataController {

	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final UserService userService;

	@PostMapping("/post")
	public @ResponseBody String post(@RequestBody Post post) {
		postRepository.save(post);
		return "글쓰기 완료";
	}

	@PostMapping("/tag")
	public String keyword(@RequestBody Tag tag) {
		return "태그 완료";
	}

	@GetMapping("/saveposts")
	public String getPosts(NowService nowService) {
		List<Post> posts = null;
		try {
			posts = nowService.getBrunchDatas();
			postRepository.saveAll(posts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "포스트 저장완료";
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
	
	@DeleteMapping("/admin/user/{id}")
	public @ResponseBody int deleteById(@PathVariable int id) {
		System.out.println("Controller : " + id);
		userService.삭제하기(id);
		return id;
	}
}
