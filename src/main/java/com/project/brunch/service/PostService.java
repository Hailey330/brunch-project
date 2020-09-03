package com.project.brunch.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.brunch.config.auth.LoginUserAnnotation;
import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostMapper;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostMapper postMapper;

	@Transactional(readOnly = true)
	public List<Post> 목록보기() {
		try {
			return postMapper.PostList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(readOnly = true)
	public List<Post> 작가의서랍(int id) {
		try {
			return postMapper.findBy작가의서랍(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(readOnly = true)
	public List<Post> 태그별글목록 (String tag){
		
		try {
			return postMapper.findBy태그(tag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
