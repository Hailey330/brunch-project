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

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.dto.AdminDto;
import com.project.brunch.dto.GoogleMailSend;
import com.project.brunch.dto.PostDto;
import com.project.brunch.service.AdminPostService;
import com.project.brunch.service.admin.AdminUserService;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class AdminController {
	
	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final AdminUserService adminUserService;
	private final AdminPostService adminPostService;
	
	
	private PostDto postDto;
	private GoogleMailSend googleMailSend;
	public static String useremail;
	
	@GetMapping("/admin")
	public String dashboard(Model model, Model model2) {
		
		AdminDto adminDto = adminUserService.회원Count();
		List<Post> readCountRank = adminPostService.readCountRank목록보기();
		model.addAttribute("adminDto" , adminDto).addAttribute("readCountRank", readCountRank);		
		
		return "dashboard";
	}
	
	@GetMapping("/admin/user") // user 페이지에 유저들 뿌리기 
	public String userForm(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
	
		return "user";
	}
	
	@DeleteMapping("/admin/user/{id}") // user삭제시 메일전송 후 삭제
	public @ResponseBody int deleteById(@PathVariable int id) {
		// 이메일 가져오기
		useremail =adminUserService.이메일찾기(id);
		
		googleMailSend = new GoogleMailSend();
		googleMailSend.sendMail(useremail);
		
		adminUserService.삭제하기(id);
		return id;
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
}