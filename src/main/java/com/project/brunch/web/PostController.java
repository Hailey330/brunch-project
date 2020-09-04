package com.project.brunch.web;

import java.util.List;
import java.util.Optional;

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
<<<<<<< HEAD
import com.project.brunch.domain.tag.Tag;
import com.project.brunch.domain.tag.TagRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.service.PostService;
import com.project.brunch.service.UserService;
import com.project.brunch.service.crawling.post.NowService;
=======
import com.project.brunch.service.PostService;
>>>>>>> master

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch")
@RequiredArgsConstructor
public class PostController {

	private final PostRepository postRepository;
<<<<<<< HEAD
	private final TagRepository tagRepository;
	private final UserService userService;
	private final PostService postService;
	
	@GetMapping("tags")
	public List<Tag> getTags() {
		return tagRepository.findAll();
	}
	
	// react, android : 글쓰기
	@PostMapping("/post/save")
	public @ResponseBody String post(@RequestBody Post post, @LoginUserAnnotation LoginUser loginUser) {
		
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
=======
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
>>>>>>> master
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
<<<<<<< HEAD
	
	// react : 메인페이지 맨 위 포스트 / android : 브런치나우 (글목록(최신순)), 메인페이지
	// 만약에 갯수제한할거면 나중에 언니랑 덕이가 말해주면 우리가 수정하면 됨
	@GetMapping("/postlist")
	public List<Post> getPosts(){ // requestDispatcher
		return postService.목록보기();
=======
>>>>>>> master

	// 포스팅 메인 페이지 Dto 뿌리기
	// 안드로이드 주소 맞추기 main/post -> post/main
	@GetMapping("/post/main")
	public List<Post> postMain() {
		return postService.메인목록();
	}
<<<<<<< HEAD
	
	@GetMapping("/post/writer")
	public List<Post> getWriterPost(@LoginUserAnnotation LoginUser loginUser) {
		
		return postService.작가의서랍(loginUser.getId());
	}
	
	// react : (메인)태그별글목록 , android : (브런치나우) 태그별 글목록
	@GetMapping("/post/list/{tag}") 
	public List<Post> getTagPostList(String tag) {
		
		return postService.태그별글목록(tag);
	}
	
=======

>>>>>>> master
}
