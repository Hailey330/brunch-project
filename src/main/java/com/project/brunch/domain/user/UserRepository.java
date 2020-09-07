package com.project.brunch.domain.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findBySnsId(String snsId);

	public List<User> findBynickName(String keyword);
	
	// 관리자
	public Page<User> findAll(Pageable pageable); // admin user 페이징 처리
	public List<User> findByNickNameContaining(String keyword);

	Page<User> findByUserRole(UserRole userRole, Pageable pageable);

}
