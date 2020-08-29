package com.project.brunch.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.dto.GoogleMailSend;
import com.project.brunch.dto.PostDto;
import com.project.brunch.service.PostService;
import com.project.brunch.service.admin.AdminUserService;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class AdminController {
	
	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final AdminUserService userService;
	private final PostService postService;
	
	private PostDto postDto;
	private GoogleMailSend googleMailSend;
	public static String useremail;
	
	@GetMapping("/admin")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/admin/user")
	public String userForm(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
	
		return "user";
	}
	
	@GetMapping("/admin/post")
	public String postForm() {
		return "post";
	}	
	
	@GetMapping("/admin/main")
	public String adminMainForm() {
		return "main";
	}	
	
	@GetMapping("/admin/comment")
	public String admincommentForm() {
		return "comment";
	}	

	@DeleteMapping("/admin/user/{id}")
	public @ResponseBody int deleteById(@PathVariable int id) {
		// 이메일 가져오기
		useremail =userService.이메일찾기(id);
		
		googleMailSend = new GoogleMailSend();
		googleMailSend.sendMail(useremail);
		
		userService.삭제하기(id);
		return id;
	}
}