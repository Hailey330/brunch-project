package com.project.brunch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.comment.Comment;
import com.project.brunch.domain.comment.CommentRepository;
import com.project.brunch.domain.post.Post;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final CommentRepository commentRepository;
	
	@Transactional
	public void 댓글저장(Comment comment, LoginUser loginUser, Post post) {
		Comment commentSave = Comment.builder()
				.postId(post.getId())
				.userId(loginUser.getId())
				.createDate(comment.getCreateDate())
				.content(comment.getContent())
				.build();
		
		commentRepository.save(commentSave);
	}
}
