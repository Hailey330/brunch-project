package com.project.brunch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.like.PostLike;
import com.project.brunch.domain.like.PostLikeRepository;
import com.project.brunch.domain.post.Post;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostLikeService {

	private final PostLikeRepository postLikeRepository;
	
	@Transactional
	public void 좋아요(Post post, LoginUser loginUser) {
		PostLike like = PostLike.builder()
				.postId(post.getId())
				.userId(loginUser.getId())
				.build();
		
		postLikeRepository.save(like);
	}
}
