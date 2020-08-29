package com.project.brunch.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.config.auth.GoogleMailSend;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserMapper;
import com.project.brunch.domain.user.UserRepository;

@Service
public class AdminUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
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
	
	
}
