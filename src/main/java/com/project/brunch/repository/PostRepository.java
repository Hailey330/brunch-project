package com.project.brunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.brunch.domain.post.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
}
