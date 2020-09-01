package com.project.brunch.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.config.auth.GoogleMailSend;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostMapper;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserMapper;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.web.dto.AdminDto;

@Service
public class AdminUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired 
	private PostMapper postMapper;
	
	private GoogleMailSend googleMailSend;
	
	@Transactional
	public String 이메일찾기(int id) {
		
		User user = userMapper.findByDelUserEmail(id);
		user.getEmail();
		System.out.println("UserService : 이메일찾기 : "+user);
		
		return user.getEmail();
	}
	
	@Transactional
	public void 삭제하기(int id) {
		User user = userRepository.findById(id).get();
		System.out.println("UserService : 삭제하기 : " + id);
		userRepository.delete(user);
	}
	
	@Transactional
	public AdminDto 회원Count() {
		int allUserCount;
		int allPostCount;
		int todayPostCount = 0;
		
		// 전체 유저 수
		List<User> userEntity = userRepository.findAll();
		allUserCount = userEntity.size();
		
		// 전체 글 수 
		List<Post> postEntity = postRepository.findAll();
		allPostCount = postEntity.size();
		
		// 오늘 올라온 글 수
		try {
			List<Post> todayPostEntity = postMapper.findByTodayPost();
			todayPostCount = todayPostEntity.size();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AdminDto adminDto = AdminDto.builder()
				.allUserCount(allUserCount)
				.allPostCount(allPostCount)
				.todayPostCount(todayPostCount)
				.build();
		
		return adminDto;
	}
	
	
}
