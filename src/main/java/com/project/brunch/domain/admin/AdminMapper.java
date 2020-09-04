package com.project.brunch.domain.admin;

import java.util.List;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.user.User;

//mapper - admin.xml
public interface AdminMapper {

 	public List<Post> findByTodayPost();
	public List<Post> findByReadCountRank();
	public List<Post> findBylikeCountRank();
	public List<Post> 최근업데이트();
	public User findByDelUserEmail(int id);
	public User findByUserEmail(String email);

}
