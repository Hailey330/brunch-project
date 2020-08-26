package com.project.brunch.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findById(String username);
	public User findById(int id);

}
