package com.project.brunch.service;

import java.util.Map;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.config.handler.exception.MyUserIdNotFoundException;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserMapper;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.web.dto.user.UserNavProfileRespDto;
import com.project.brunch.web.dto.user.UserProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Transactional(readOnly = true)
	public UserProfileRespDto 작가프로필(int id, LoginUser loginUser) {
		return null;
	}
	
	
	@Transactional
	public UserProfileRespDto 프로필수정하기(Map<String, Object> data, LoginUser loginUser) {
		
		String bio = (String) data.get("bio");
		String nickName = (String) data.get("nickName");
		String profileImage = (String) data.get("profileImage");
		
		UserProfileRespDto userProfileRespDto = UserProfileRespDto.builder()
				.id(loginUser.getId())
				.nickName(nickName)
				.bio(bio)
				.profileImage(profileImage)
				.build();
		
		userMapper.update(userProfileRespDto);
		
		return userProfileRespDto;
	}

	@Transactional(readOnly = true)
	public UserNavProfileRespDto 로그인유저찾기(LoginUser loginUser) {
		// 1. User 찾기
		User userEntity = userRepository.findById(loginUser.getId())
				.orElseThrow(new Supplier<MyUserIdNotFoundException>() {

			@Override
			public MyUserIdNotFoundException get() {
				return new MyUserIdNotFoundException();
			}
		});
		// 2. nickName, profileImage 꺼내오기 
		String nickName = userEntity.getNickName();
		String profileImage = userEntity.getProfileImage();
		
		UserNavProfileRespDto userNavProfileRespDto = UserNavProfileRespDto.builder()
				.nickName(nickName)
				.profileImage(profileImage)
				.build();
		
		return userNavProfileRespDto;
	}

}
