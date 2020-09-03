package com.project.brunch.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostMapper;
import com.project.brunch.domain.post.PostRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

	private final PostMapper postMapper;
	private final PostRepository postRepository;

	@Transactional
	public void 글저장(Post post, LoginUser loginUser) {
		Post savePost = Post.builder()
				.content(post.getContent())
				.coverImg(post.getCoverImg())
				.createDate(post.getCreateDate())
				.subTitle(post.getSubTitle())
				.title(post.getTitle())
				.userId(loginUser.getId())
				.build();
		
		postRepository.save(savePost);
	}

	@Transactional(readOnly = true)
	public List<Post> 작가의서랍(int id) {
		return postMapper.findBy작가의서랍(id);
	}

	@Transactional(readOnly = true)
	public List<Post> 태그별글목록(String tag) {
		return postMapper.findBy태그(tag);
	}

	@Transactional(readOnly = true)
	public List<Post> 메인목록() {
		return postMapper.findAllPost();
	}

}
