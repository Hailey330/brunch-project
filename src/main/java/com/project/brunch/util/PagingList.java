package com.project.brunch.util;

import org.springframework.stereotype.Service;

import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagingList {
	
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	
	// 페이징
	private final int BLOCK_PAGE_NUM_COUNT = 15; // 블럭에 존재하는 페이지 번호 수
	private final int PAGE_POST_COUNT = 8; // 한 페이지에 존재하는 게시글 수

	
	public Integer[] 포스팅페이지불러오기(Integer nowPageNum) {

		Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

		// 총 게시글 갯수
		Double postsTotalCount = Double.valueOf(postRepository.count());

		// 총 게시글 기준으로 계산한 마지막 페이지 번호 계산 (올림으로 계산)
		Integer totalLastPageNum = (int) (Math.ceil((postsTotalCount / PAGE_POST_COUNT)));

		// 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
		Integer blockLastPageNum = (totalLastPageNum > nowPageNum + BLOCK_PAGE_NUM_COUNT)
				? nowPageNum + BLOCK_PAGE_NUM_COUNT
				: totalLastPageNum;

		// 페이지 시작 번호 조정
		nowPageNum = (nowPageNum <= 9) ? 1 : nowPageNum - 2;

		// 페이지 번호 할당
		for (int val = nowPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
			pageList[idx] = val;
		}
		return pageList;
	}
	
	public Integer[] 유저페이지불러오기(Integer nowPageNum) {

		Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

		// 총 게시글 갯수
		Double postsTotalCount = Double.valueOf(userRepository.count());

		// 총 게시글 기준으로 계산한 마지막 페이지 번호 계산 (올림으로 계산)
		Integer totalLastPageNum = (int) (Math.ceil((postsTotalCount / PAGE_POST_COUNT)));

		// 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
		Integer blockLastPageNum = (totalLastPageNum > nowPageNum + BLOCK_PAGE_NUM_COUNT)
				? nowPageNum + BLOCK_PAGE_NUM_COUNT
				: totalLastPageNum;

		// 페이지 시작 번호 조정
		nowPageNum = (nowPageNum <= 14) ? 1 : nowPageNum - 2;

		// 페이지 번호 할당
		for (int val = nowPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
			pageList[idx] = val;
		}
		return pageList;
	}
}
