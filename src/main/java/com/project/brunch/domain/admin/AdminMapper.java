package com.project.brunch.domain.admin;

import java.util.List;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.user.User;

//mapper - admin.xml
public interface AdminMapper {

 	public List<Post> findByTodayPost();
	public List<Post> findByReadCountRank();
	public User findByDelUserEmail(int id);
	public User findByUserEmail(String email);

}
