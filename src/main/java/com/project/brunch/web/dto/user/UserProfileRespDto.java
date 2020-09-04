package com.project.brunch.web.dto.user;

import java.util.List;

import com.project.brunch.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserProfileRespDto {
	private User user; // 유저 정보
	private List<UserProfilePostRespDto> posts;
	private int followerCount; // 나를 구독하는 작가
	private int followingCount; // 내가 구독하는 작가 
	private boolean followState; // 팔로우 유무 체크 : true(구독해지), false(구독하기)
	private int postCount; // 유저가 쓴 글 수
}
