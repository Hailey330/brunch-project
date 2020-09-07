package com.project.brunch.service.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.domain.admin.AdminMapper;
import com.project.brunch.domain.post.Post;
import com.project.brunch.web.dto.admin.CommentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminCommentService {
	
	private final AdminMapper adminMapper;

	@Transactional
	public List<CommentDto> getCommentList() {

		return adminMapper.CommentList();
	}
}
