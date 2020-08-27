package com.project.brunch.service.crawling.post;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostMapper;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImgService {

	private final PostRepository postRepository;
	private final PostMapper postMapper;
	
	@Transactional
	public Post 사진불러오기(int id) {
//		Post img = postM.findById(id);
		return null;
	}
}
