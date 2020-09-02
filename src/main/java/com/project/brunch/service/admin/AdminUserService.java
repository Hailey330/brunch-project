package com.project.brunch.service.admin;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.domain.admin.AdminMapper;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.web.dto.admin.AdminDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminUserService {

	private String TAG = "< AdminUserService >";
	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final AdminMapper adminMapper;

	// By_아령
	@Transactional
	public String 이메일찾기(int id) {
		User user = adminMapper.findByDelUserEmail(id);
		user.getEmail();
		System.out.println(TAG + "이메일찾기 : " + user);
		return user.getEmail();
	}

	@Transactional
	public void 삭제하기(int id) {
		User user = userRepository.findById(id).get();
		System.out.println(TAG + "삭제하기 : " + id);
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
			List<Post> todayPostEntity = adminMapper.findByTodayPost();
			todayPostCount = todayPostEntity.size();

		} catch (Exception e) {
			e.printStackTrace();
		}

		AdminDto adminDto = AdminDto.builder().allUserCount(allUserCount).allPostCount(allPostCount)
				.todayPostCount(todayPostCount).build();

		return adminDto;
	}

	@Transactional // user 검색기능 구현중
	public List<User> searchUsers(String keyword) {

		List<User> userEntities = userRepository.findBynickName(keyword);
		List<User> userList = userRepository.findAll();

		if (userEntities.isEmpty())
			return userList;

		for (User user : userEntities) {
//			userList.add(this.convertEntityToDto(user));
		}
		return userList;
	}

}
