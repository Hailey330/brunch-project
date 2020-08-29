package com.project.brunch.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserMapper;
import com.project.brunch.domain.user.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional(readOnly = true)
	public User 로그인유저찾기(String email) {
		return userMapper.findByUserEmail(email);
	}
}
