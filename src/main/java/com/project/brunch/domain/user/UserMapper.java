package com.project.brunch.domain.user;

import java.util.List;

public interface UserMapper {
	
	public User findByDelUserEmail(int id);
	public User findByUserEmail(String email);
	public List<User> findByUser() throws Exception;
}
