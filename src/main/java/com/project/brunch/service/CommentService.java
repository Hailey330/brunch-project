package com.project.brunch.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.comment.Comment;
import com.project.brunch.domain.comment.CommentMapper;
import com.project.brunch.domain.comment.CommentRepository;
import com.project.brunch.domain.post.Post;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final CommentMapper commentMapper;
	
	// By_아령
	@Transactional
	public void 댓글저장(Comment comment, LoginUser loginUser, int postId) {
		Comment commentSave = Comment.builder()
				.postId(postId)
				.userId(loginUser.getId())
				.createDate(comment.getCreateDate())
				.content(comment.getContent())
				.build();
		
		System.out.println("ComementService : commentSave : " + commentSave);
		commentRepository.save(commentSave);
	}
	
	// By_아령
	@Transactional(readOnly = true)
	public List<Comment> 댓글뿌리기( int postId) {

		return commentMapper.findByComment( postId);
	}
}
