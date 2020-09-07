package com.project.brunch.domain.admin;

import java.util.List;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.user.User;
import com.project.brunch.web.dto.admin.AdminDto;
import com.project.brunch.web.dto.admin.CommentDto;

//mapper - admin.xml
public interface AdminMapper {

 	public List<Post> findByTodayPost();
	public List<AdminDto> findByReadCountRank();
	public List<AdminDto> findBylikeCountRank();
	public List<AdminDto> 최근업데이트();
	public List<AdminDto> 메인포스트가져오기();
	public List<Post> 메인포스트값변경하기();
	public User findByDelUserEmail(int id);
	public User findByUserEmail(String email);
	public List<CommentDto> CommentList();

}
