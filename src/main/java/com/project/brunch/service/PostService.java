package com.project.brunch.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostMapper;
import com.project.brunch.domain.post.PostRepository;

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
}
