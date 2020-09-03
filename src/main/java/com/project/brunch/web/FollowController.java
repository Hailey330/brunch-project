package com.project.brunch.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.domain.follow.Follow;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch")
@RequiredArgsConstructor
public class FollowController {

	private String TAG = "< FollowController > ";

	// 내가 팔로우한 유저 프로필 정보 뿌리기
	@GetMapping("/follow/proflie")
	public List<Follow> followProfile() {
		return null;
	}
}
