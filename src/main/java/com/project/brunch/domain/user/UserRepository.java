package com.project.brunch.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.brunch.domain.post.Post;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findBySnsId(String snsId);

	public List<User> findBynickName(String keyword);
	
	// 관리자
	public List<User> findByNickNameContaining(String keyword);

}
