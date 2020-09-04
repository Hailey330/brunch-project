package com.project.brunch.domain.admin;

import java.util.List;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.user.User;
import com.project.brunch.web.dto.admin.AdminDto;

//mapper - admin.xml
public interface AdminMapper {

 	public List<Post> findByTodayPost();
	public List<AdminDto> findByReadCountRank();
	public List<AdminDto> findBylikeCountRank();
	public List<AdminDto> 최근업데이트();
	public User findByDelUserEmail(int id);
	public User findByUserEmail(String email);

}
