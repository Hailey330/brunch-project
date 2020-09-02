package com.project.brunch.domain.post;

import java.util.List;

//mapper - post.xml
public interface PostMapper {

	// By_민경
	public List<Post> findAllPost();

	// By_아령
	void UpdateByPost(int id) throws Exception;

	List<Post> PostList() throws Exception;

	List<Post> findByTodayPost() throws Exception;

	List<Post> findByreadCountRank() throws Exception;
}
