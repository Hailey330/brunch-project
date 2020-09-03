package com.project.brunch.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserProfileRespDto {
	private int id;
	private String nickName;
	private String profileImage;
	private String bio;
	private int followerCount; // 나를 구독하는 작가
	private int followingCount; // 내가 구독하는 작가 
	private boolean followState; // 팔로우 유무 체크 : true(구독해지), false(구독하기)
	
}
