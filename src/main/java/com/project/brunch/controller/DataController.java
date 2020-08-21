package com.project.brunch.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.tag.Tag;
import com.project.brunch.domain.user.User;
import com.project.brunch.repository.PostRepository;
import com.project.brunch.repository.UserRepository;
import com.project.brunch.service.crawling.user.NowCrawling;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class DataController {

	private final UserRepository userRepository;
	private final PostRepository postRepository;

	@PostMapping("/post")
	public String post(@RequestBody Post post) {
		postRepository.save(post);
		return "글쓰기 완료";
	}

	@PostMapping("/tag")
	public String keyword(@RequestBody Tag tag) {
		return "태그 완료";
	}

	@GetMapping("/saveposts")
	public List<Post> getPosts() {
		return postRepository.findAll();
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
}
