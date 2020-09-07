package com.project.brunch.domain.post;

import java.util.List;

import com.project.brunch.web.dto.post.PostRespDto;

//mapper - post.xml
public interface PostMapper {

	// By_민경
	public List<Post> findAllPost();

	// By_아령
	public void updateByPost(int id);
	List<Post> findBy작가의서랍(int id);
	List<PostRespDto> findBy태그(String tag);

}
