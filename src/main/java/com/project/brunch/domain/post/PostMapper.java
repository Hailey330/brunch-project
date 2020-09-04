package com.project.brunch.domain.post;

import java.util.List;

<<<<<<< HEAD
import com.project.brunch.domain.user.User;

public interface PostMapper {

	void UpdateByPost(int id) throws Exception; 
	List<Post> PostList() throws Exception;
	List<Post> findByTodayPost() throws Exception;
	List<Post> findByreadCountRank() throws Exception;
	List<Post> findBy작가의서랍(int id) throws Exception;
	List<Post> findBy태그(String tag) throws Exception;
=======
//mapper - post.xml
public interface PostMapper {

	// By_민경
	public List<Post> findAllPost();

	// By_아령
	public void updateByPost(int id);
	List<Post> findBy작가의서랍(int id);
	List<Post> findBy태그(String tag);

>>>>>>> master
}
