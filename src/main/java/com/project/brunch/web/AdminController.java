package com.project.brunch.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.service.admin.AdminPostService;
import com.project.brunch.service.admin.AdminUserService;
import com.project.brunch.web.dto.AdminDto;
import com.project.brunch.web.dto.GoogleMailSend;
import com.project.brunch.web.dto.PostDto;
import com.project.brunch.web.dto.UserDto;

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

	
	// 관리자 로그인 
	@GetMapping("/admin/login")
	public String adminLoginForm() {
		
		return "adminlogin";
	}

	// 관리자 메인 대시보드 
	@GetMapping("/admin")
	public String dashboard(Model model, Model model2) {
		AdminDto adminDto = adminUserService.회원Count();
		List<Post> readCountRank = adminPostService.readCountRank목록보기();
		model.addAttribute("adminDto", adminDto).addAttribute("readCountRank", readCountRank);
		
		return "dashboard";
	}

	// 관리자 유저 목록 뿌리기 - 페이징 구현중
	@GetMapping("/admin/user")
	public String userForm(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);

		return "user";
	}

	// 관리자 유저 목록 검색하기
	@GetMapping("/admin/usersearch")
	public String userSearch(@RequestParam(value = "keyword") String keyword, Model model) {
		List<User> userList = adminUserService.searchUsers(keyword);
		model.addAttribute("userList", userList);

		return "user";
	}

	// 관리자 유저 삭제 - 메일 전송 날리기 완료
	@DeleteMapping("/admin/user/{id}")
	public @ResponseBody int deleteById(@PathVariable int id) {
		
		// 이메일 가져오기
		useremail = adminUserService.이메일찾기(id);

		googleMailSend = new GoogleMailSend();
		googleMailSend.sendMail(useremail);
		adminUserService.삭제하기(id);
		
		return id;
	}

	// 관리자 포스팅 목록 뿌리기 - 페이징 구현중
	@GetMapping("/admin/post")
	public String postForm(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
		List<Post> postList = adminPostService.getPostList(pageNum);
		
		return "post";
	}

	// 관리자 포스팅 삭제 - 메일 전송 날리기 구현중
	@DeleteMapping("/admin/post/del/{id}")
	public @ResponseBody int delete(@PathVariable int id) {
		adminPostService.delete(id);
		
		return id;
	}
	
	@GetMapping("/admin/main")
	public String adminMainForm() {
		return "main";
	}

	@GetMapping("/admin/comment")
	public String adminCommentForm() {
		return "comment";
	}
}