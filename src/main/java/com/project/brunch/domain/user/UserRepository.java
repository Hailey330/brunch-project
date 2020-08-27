package com.project.brunch.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findBySnsId(String snsId);


}
