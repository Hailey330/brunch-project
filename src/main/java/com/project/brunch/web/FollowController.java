package com.project.brunch.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.config.auth.LoginUserAnnotation;
import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.service.FollowService;
import com.project.brunch.web.dto.follow.FollowCountDto;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch")
@RequiredArgsConstructor
public class FollowController {

	private String TAG = "< FollowController > ";
	private final FollowService followService;

	// 팔로워리스트
	@GetMapping("follow/followerList/{pageUserId}")
	public FollowCountDto followerList(@PathVariable int pageUserId, @LoginUserAnnotation LoginUser loginUser) {
		FollowCountDto followerEntity = followService.팔로워리스트(loginUser.getId(), pageUserId);
		return followerEntity;
	}

	// 팔로잉리스트
	@GetMapping("/follow/followingList/{pageUserId}")
	public FollowCountDto followingList(@PathVariable int pageUserId, @LoginUserAnnotation LoginUser loginUser) {
		FollowCountDto followingEntity = followService.팔로잉리스트(loginUser.getId(), pageUserId);
		return followingEntity;
	}

}
