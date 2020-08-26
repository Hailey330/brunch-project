package com.project.brunch.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void 삭제하기(int id) {
		User user = userRepository.findById(id);
		System.out.println("UserService 삭제하기 : " + id);
		userRepository.delete(user);
	}
	
	
}
