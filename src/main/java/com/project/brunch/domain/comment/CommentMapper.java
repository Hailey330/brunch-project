package com.project.brunch.domain.comment;

import java.util.List;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.post.Post;
import com.project.brunch.web.dto.admin.CommentDto;

public interface CommentMapper {

	// By_아령
	List<CommentDto> findByComment(int postId);
}
