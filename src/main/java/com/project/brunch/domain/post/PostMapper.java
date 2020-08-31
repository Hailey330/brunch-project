package com.project.brunch.domain.post;

import java.util.HashMap;
import java.util.List;

public interface PostMapper {

	void UpdateByPost(int id) throws Exception; 
	List<Post> PostList() throws Exception;
	List<Post> findByTodayPost() throws Exception;
	List<Post> findByreadCountRank() throws Exception;
}
