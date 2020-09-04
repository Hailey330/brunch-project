package com.project.brunch.domain.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

	// By_민경
	Page<Post> findAll(Pageable pageable); // admin post 페이징 처리
}
