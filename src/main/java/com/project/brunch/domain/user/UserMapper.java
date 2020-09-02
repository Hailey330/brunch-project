package com.project.brunch.domain.user;

import java.util.List;

//mapper - user.xml
public interface UserMapper {

	// By_민경
	public void update(User user);

	// By_아령
	public User findByDelUserEmail(int id);

	public User findByUserEmail(String email);

	public List<User> findByUser() throws Exception;
}
