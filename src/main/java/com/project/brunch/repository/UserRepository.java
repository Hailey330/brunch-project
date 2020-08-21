package com.project.brunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.brunch.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findById(String username);

}
