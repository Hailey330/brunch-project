package com.project.brunch.config.auth;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	private final HttpSession session;
	
	@Override
	public UserDetails loadUserByUsername(String snsId) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailsService : 진입");
		User userEntity = userRepository.findBySnsId(snsId);
		
		if (userEntity != null) {
			// 세션 등록하기
			session.setAttribute("loginUser", new LoginUser(userEntity));
			System.out.println("PrincipalDetailsService session 확인 : " + session);
		}
		
		return new PrincipalDetails(userEntity);
	}

}
