package com.project.brunch.domain.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findBySubTitle(String subtitle);
}
