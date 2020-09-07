package com.project.brunch.domain.post;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.brunch.web.dto.user.UserProfilePostRespDto;

public interface PostRepository extends JpaRepository<Post, Integer> {

	public List<Post> findByUserId(int id);

	// 관리자
	public Page<Post> findAll(Pageable pageable); // admin post 페이징 처리
	public List<Post> findByTitleContaining(String keyword);
}
