package com.project.brunch.web.dto.user;

import com.project.brunch.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// 유저 메인 프로필
// 유저 정보 + 소개 + 팔로우 수 + 유저가 쓴 글 수 
public class UserProfileRespDto {
	private User user; // 유저 정보
	private int followerCount; // 나를 구독하는 작가
	private int followingCount; // 내가 구독하는 작가 
	private boolean followState; // 팔로우 유무 체크 : true(구독해지), false(구독하기)
	private int postCount; // 유저가 쓴 글 수
}
