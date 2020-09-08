package com.project.brunch.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.brunch.domain.comment.CommentRepository;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.domain.user.UserRole;
import com.project.brunch.service.admin.AdminCommentService;
import com.project.brunch.service.admin.AdminPostService;
import com.project.brunch.service.admin.AdminUserService;
import com.project.brunch.util.GoogleMailSend;
import com.project.brunch.util.MyPage;
import com.project.brunch.util.PagingList;
import com.project.brunch.web.dto.admin.AdminDto;
import com.project.brunch.web.dto.admin.AdminSearchDto;
import com.project.brunch.web.dto.admin.CommentDto;
import com.project.brunch.web.dto.post.PostRespDto;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("brunch")
@RequiredArgsConstructor
public class AdminController {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final CommentRepository commentRepository;
	private final AdminUserService adminUserService;
	private final AdminPostService adminPostService;
	private final PagingList pagingList;
	private final AdminCommentService adminCommentService;

	private PostRespDto postDto;
	private GoogleMailSend googleMailSend;
	public static String useremail;

	// 관리자 로그인
	@GetMapping("/admin/login")
	public String adminLoginForm() {
		log.info("/admin/loginForm 진입");
		return "login";
	}

	// 관리자 메인 대시보드
	@GetMapping("/admin")
	public String adminDashForm(Model model) {
		AdminDto adminDto = adminUserService.회원Count();
		List<AdminDto> readCountRank = adminPostService.readCountRank목록보기();
		for (int i = 0; i < readCountRank.size(); i++) {
			readCountRank.get(i).setRank(i + 1);
		}
		List<AdminDto> updatePost = adminPostService.최근업데이트글();
		for (int i = 0; i < updatePost.size(); i++) {
			updatePost.get(i).setRank(i + 1);
		}
		List<AdminDto> likeCountRank = adminPostService.likeCountRank목록보기();
		for (int i = 0; i < likeCountRank.size(); i++) {
			likeCountRank.get(i).setRank(i + 1);
		}

		model.addAttribute("adminDto", adminDto)
			.addAttribute("readCountRank", readCountRank)
			.addAttribute("updatePost", updatePost)
			.addAttribute("likeCountRank", likeCountRank);

		return "dashboard";
	}
	
	@PutMapping("/brunch/admin/main/{id}")
	public List<Post> mainPostUpate(@PathVariable int id) {
		List<Post> postBoolean = adminPostService.메인포스트값변경하기();
		
		return postBoolean;
	}

	// 관리자 유저 목록 뿌리기 - 페이징
//	@GetMapping("/admin/user")
//	public String userList(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
//		List<AdminSearchDto> adminSearchDto = adminUserService.유저불러오기(pageNum);
//		Integer[] pageList = pagingList.유저페이지불러오기(pageNum);
//		
//		model.addAttribute("userlist", adminSearchDto);
//		model.addAttribute("pagelist", pageList);
//		
//		return "user";
//	}
	
	// 유저 페이징 테스트
	@GetMapping("/admin/user")
	public String userListTest(
			Model model, 
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		UserRole userRole = userRepository.findAll().get(0).getUserRole().USER;
		Page<User> users = userRepository.findByUserRole(userRole, pageable);
		model.addAttribute("users", users);
		List<MyPage> lists = new ArrayList<MyPage>();
		for (int i=1; i<users.getTotalPages(); i++) {
			lists.add(new MyPage(i));
		}
		model.addAttribute("lists", lists);
		return "user";
	}

	// 관리자 유저 목록 검색하기
	@GetMapping("/admin/user/search")
	public String adminUserSearch(@RequestParam(value="keyword") String keyword, Model model) {
		List<AdminSearchDto> adminSearchDto = adminUserService.유저검색하기(keyword);
		model.addAttribute("search", adminSearchDto);
		return "user";
	}

	// 관리자 유저 삭제 - 메일 전송 날리기 완료
	@DeleteMapping("/admin/user/{id}")
	public @ResponseBody int adminUserDelete(@PathVariable int id) {
		// 이메일 가져오기
		useremail = adminUserService.이메일찾기(id);
		googleMailSend = new GoogleMailSend();
		googleMailSend.sendMail(useremail);
		adminUserService.삭제하기(id);
		return id;
	}

	// 관리자 포스팅 목록 뿌리기 - 페이징 
	@GetMapping("/admin/post")
	public String postList(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
		List<AdminSearchDto> adminSearchDto = adminPostService.포스팅불러오기(pageNum);
		Integer[] pageList = pagingList.포스팅페이지불러오기(pageNum);
		
		model.addAttribute("postlist", adminSearchDto);
		model.addAttribute("pagelist", pageList);
		
		return "post";
	}
	
	// 관리자 포스팅 삭제 - 메일 전송 날리기 구현중
	@DeleteMapping("/admin/post/{id}")
	public @ResponseBody int adminPostDelete(@PathVariable int id) {
		adminPostService.delete(id);

		return id;
	}

	// 관리자 포스팅 검색하기
	@GetMapping("/admin/post/search")
	public String adminPostSearch(@RequestParam(value="keyword") String keyword, Model model) {
		List<AdminSearchDto> adminSearchDto = adminPostService.포스팅검색하기(keyword);
		model.addAttribute("search", adminSearchDto);
		return "post";
	}
	
	// 관리자 메인 컨트롤 페이지 이동 (메인포스트가져오기)

	@GetMapping("/admin/main")
	public String adminMainForm(Model model) {
		List<AdminDto> getMainPost = adminPostService.메인포스트가져오기();
		model.addAttribute("getMainPost", getMainPost);
		
		System.out.println("AdminController : mainpost : " + getMainPost);
		return "main";
	}

	// 관리자 댓글 컨트롤 페이지 이동
	@GetMapping("/admin/comment")
	public String adminCommnetForm(Model model) {
		
		List<CommentDto> comments = adminCommentService.getCommentList();
		model.addAttribute("comments", comments);
		
		return "comment";
	}
}