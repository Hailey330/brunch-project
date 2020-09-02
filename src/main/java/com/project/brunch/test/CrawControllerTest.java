package com.project.brunch.test;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;

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
	
	@GetMapping("brunch/test/sendpostimg")
	@ResponseBody
	public String sendpostimg(Model model) {
		
		String imgUrl = "<img src=\"data:image/png;base64,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\">";
		Post postTest = Post.builder()
				.content(imgUrl)
				.build();
		
		postRepository.save(postTest);
		
		return "이미지 저장완료";
	}

}
