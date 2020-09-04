package com.project.brunch.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.config.auth.LoginUserAnnotation;
import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.post.Post;
import com.project.brunch.service.PostLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch")
@RequiredArgsConstructor
public class PostLikeController {
	
	private final PostLikeService postLikeService;

	// 좋아요 누르면 save
	@PostMapping("/post/like")
	public @ResponseBody String like(@RequestBody Post post, @LoginUserAnnotation LoginUser loginUser) {
		postLikeService.좋아요(post, loginUser);
		
		return "좋아요 완료";
	}
}
