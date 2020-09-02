package com.project.brunch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostMapper;
import com.project.brunch.domain.post.PostRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

	private final PostMapper postMapper;

	// By_민경
	@Transactional(readOnly = true)
	public List<Post> 메인목록() {
		return postMapper.findAllPost();
	}

	// By_아령
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
