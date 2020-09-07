package com.project.brunch.domain.comment;

import java.util.List;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.post.Post;

public interface CommentMapper {

	// By_아령
	List<Comment> findByComment(int postId);
}
