package com.project.brunch.service.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.domain.admin.AdminMapper;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostMapper;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminPostService {

	private final PostRepository postRepository;
	private final AdminMapper adminMapper;
	private final UserRepository userRepository;

	// 페이징 관련
	private final int BLOCK_PAGE_NUM_COUNT = 5; // 블럭에 존재하는 페이지 번호 수
	private final int PAGE_POST_COUNT = 5; // 한 페이지에 존재하는 게시글 수

	// By_민경 : 페이징
	@Transactional
	public List<Post> getPostList(Integer pageNum) {
		Page<Post> page = postRepository
				.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));
		List<Post> postEntity = page.getContent();
		return null;
	}

	// By_민경 : 포스팅 삭제하기
	@Transactional
	public void delete(int id) {
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 포스팅이 없습니다. id = " + id));
		postRepository.delete(post);
	}

	// By_아령 : 포스팅 카운트
	@Transactional(readOnly = true)
	public List<Post> readCountRank목록보기() {
		return adminMapper.findByReadCountRank();
	}
}
