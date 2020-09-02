package com.project.brunch.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserMapper;
import com.project.brunch.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	// By_민경
	@Transactional
	public void 수정하기(Map<String, Object> data, int userId) {
		
		String bio = (String) data.get("bio");
		String nickName = (String) data.get("nickName");
		String profileImage = (String) data.get("profileImage");
		
		// 여기서 받아서 DB update 쿼리 날리고 
		User userEntity = User.builder()
				.id(userId)
				.nickName(nickName)
				.bio(bio)
				.profileImage(profileImage)
				.build();
		
		userMapper.update(userEntity);
	}

	// By_아령
	@Transactional(readOnly = true)
	public Optional<User> 로그인유저찾기(int loginUser) {

		Optional<User> userEntity = userRepository.findById(loginUser);
		return userEntity;
	}
	
	// By_아령
	@Transactional(readOnly = true)
	public List<User> 목록보기() {

		try {
			return userMapper.findByUser();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
