package com.project.brunch.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.brunch.domain.post.Post;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query(value = "SELECT count(*) FROM comment WHERE postId= ?1", nativeQuery = true)
	int mCountByComment(int postId);

}
