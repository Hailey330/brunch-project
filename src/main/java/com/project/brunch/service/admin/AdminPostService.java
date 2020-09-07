package com.project.brunch.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.domain.admin.AdminMapper;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.web.dto.admin.AdminDto;
import com.project.brunch.web.dto.admin.AdminSearchDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminPostService {

	private final PostRepository postRepository;
	private final AdminMapper adminMapper;
	private final UserRepository userRepository;

	private final int PAGE_POST_COUNT = 8; // 한 페이지에 존재하는 게시글 수

	@Transactional
	public List<AdminSearchDto> 포스팅불러오기(Integer pageNum) {
		Page<Post> page = postRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));
		List<Post> postsEntity = page.getContent();
		List<AdminSearchDto> adminSearchDto = new ArrayList<>();
		
		for (Post postEntity : postsEntity) {
			adminSearchDto
			.add(AdminSearchDto.builder()
					.id(postEntity.getId())
					.userId(postEntity.getUserId())
					.title(postEntity.getTitle())
					.createDate(postEntity.getCreateDate().toString())
					.build());
		}
		
		return adminSearchDto;
	}
	
	@Transactional
	public List<AdminSearchDto> 포스팅검색하기(String keyword) {
		// 1. 검색 키워드 들어간 포스팅 찾아오기
		List<Post> postsEntity = postRepository.findByTitleContaining(keyword);

		List<AdminSearchDto> adminSearchDto = new ArrayList<>();
		
		if (postsEntity.isEmpty()) {
			return adminSearchDto;
		}
		
		for (Post postEntity : postsEntity) {
			adminSearchDto
				.add(AdminSearchDto.builder()
						.id(postEntity.getId())
						.userId(postEntity.getUserId())
						.keyword(keyword)
						.title(postEntity.getTitle())
						.createDate(postEntity.getCreateDate().toString())
						.build());
		}
		return adminSearchDto;
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
	public List<AdminDto> readCountRank목록보기() {
		return adminMapper.findByReadCountRank();
	}
	
	// By_아령 : admin 최근 업데이트글
	@Transactional(readOnly = true)
	public List<AdminDto> 최근업데이트글() {
		return adminMapper.최근업데이트();
	}
	
	// By_아령 : 좋아요수 랭크 카운트
	@Transactional(readOnly = true)
	public List<AdminDto> likeCountRank목록보기() {
		return adminMapper.findBylikeCountRank();
	}
	
	// By_아령 : 관리자메인 포스트리스트
	@Transactional(readOnly = true)
	public List<AdminDto> 메인포스트가져오기() {
		
		return adminMapper.메인포스트가져오기();
	}
	
	@Transactional(readOnly = true)
	public List<Post> 메인포스트값변경하기() {
		
		return adminMapper.메인포스트값변경하기();
	}
}
