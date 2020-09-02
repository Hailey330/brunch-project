package com.project.brunch.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.tag.Tag;
import com.project.brunch.domain.tag.TagRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.service.PostService;
import com.project.brunch.service.UserService;
import com.project.brunch.service.crawling.post.NowService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class PostController {

	private final PostRepository postRepository;
	private final TagRepository tagRepository;
	private final UserService userService;
	private final PostService postService;
	
	@GetMapping("tags")
	public List<Tag> getTags() {
		return tagRepository.findAll();
	}
	
	// react, android : 글쓰기
	@PostMapping("/post")
	public @ResponseBody String post(@RequestBody Post post, LoginUser loginUser) {
		
		System.out.println("PostController : loginUser : " + loginUser.getId());
		Post savePost = Post.builder()
				.content(post.getContent())
				.coverImg(post.getCoverImg())
				.createDate(post.getCreateDate())
				.subTitle(post.getSubTitle())
				.title(post.getTitle())
				.userId(loginUser.getId())
				.build();
		
		postRepository.save(savePost);
		
		return "글쓰기 완료";
	}
	
	// 더미데이터 넣으려고 만들어놓은 크롤링데이터
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
	
	@GetMapping("/posts")
	public List<Post> getpost() {
		return postRepository.findAll();
	}
	
	// react : 메인페이지 맨 위 포스트 / android : 브런치나우 (글목록(최신순)), 메인페이지
	// 만약에 갯수제한할거면 나중에 언니랑 덕이가 말해주면 우리가 수정하면 됨
	@GetMapping("/postlist")
	public List<Post> getPosts(){ // requestDispatcher
		return postService.목록보기();

	}
	
}
