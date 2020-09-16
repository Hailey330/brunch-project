package com.project.brunch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.brunch.domain.follow.FollowMapper;
import com.project.brunch.domain.follow.FollowRepository;
import com.project.brunch.web.dto.follow.FollowCountDto;
import com.project.brunch.web.dto.follow.FollowRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FollowService {

	private final FollowRepository followRepository;
	private final FollowMapper followMapper;
	
	public FollowCountDto 팔로워리스트(int loginUserId, int pageUserId) {
		int followerCount;
		followerCount = followRepository.mCountByFollowing(pageUserId);
		
		List<FollowRespDto> followerListEntity = followMapper.findFollowerList(loginUserId, pageUserId);
		
		FollowCountDto followCountDto = FollowCountDto.builder()
				.followRespDto(followerListEntity)
				.followCount(followerCount)
				.build();

		System.out.println("followCountEntity 확인 : " + followCountDto);
		return followCountDto;
	}
	
	public FollowCountDto 팔로잉리스트(int loginUserId, int pageUserId) {
		int followingCount;
		followingCount = followRepository.mCountByFollowing(pageUserId);
		
		List<FollowRespDto> followingListEntity = followMapper.findFollowingList(loginUserId, pageUserId);
		
		FollowCountDto followCountDto = FollowCountDto.builder()
				.followRespDto(followingListEntity)
				.followCount(followingCount)
				.build();
		
		System.out.println("followerListEntity 확인 : " + followCountDto);
		return followCountDto;
	}
}
