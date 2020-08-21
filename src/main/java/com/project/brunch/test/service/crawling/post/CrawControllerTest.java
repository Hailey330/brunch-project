package com.project.brunch.test.service.crawling.post;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.domain.user.User;
import com.project.brunch.repository.PostRepository;
import com.project.brunch.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌

public class CrawControllerTest {

	private final UserRepository userRepository;
	private final PostRepository postRepository;

	@GetMapping("/test/senduser")
	@ResponseBody
	public List<User> sendUser(Model model) {
		List<User> userlist = userRepository.findAll();
		return userlist;
	}

//	@GetMapping("/test/getpost")
//	@ResponseBody
//	public String getPost(NowService nowService) {		
//		List<Post> posts = null;
//		try {			
//			posts = nowService.getBrunchDatas();
//			System.out.println("savePost : " + posts);
//			postRepository.saveAll(posts);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "연결 성공";
//	}

}
