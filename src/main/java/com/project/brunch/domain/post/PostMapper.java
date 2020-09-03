package com.project.brunch.domain.post;

import java.util.List;

import com.project.brunch.domain.user.User;

public interface PostMapper {

	void UpdateByPost(int id) throws Exception; 
	List<Post> PostList() throws Exception;
	List<Post> findByTodayPost() throws Exception;
	List<Post> findByreadCountRank() throws Exception;
	List<Post> findBy작가의서랍(int id) throws Exception;
	List<Post> findBy태그(String tag) throws Exception;
}
