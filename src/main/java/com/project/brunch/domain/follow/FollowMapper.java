package com.project.brunch.domain.follow;

import java.util.List;

import com.project.brunch.web.dto.follow.FollowRespDto;

public interface FollowMapper {
	List<FollowRespDto> findFollowerList(int loginUserId, int pageUserId); // 팔로잉 리스트 뿌리기
	List<FollowRespDto> findFollowingList(int loginUserId, int pageUserId); // 팔로워 리스트 뿌리기

}
