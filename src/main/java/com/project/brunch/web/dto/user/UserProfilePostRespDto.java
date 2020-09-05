package com.project.brunch.web.dto.user;

import java.util.List;

import com.project.brunch.domain.post.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// 유저 프로필 
// 유저가 쓴 글 목록(title, content, coverImg, createDate) + 댓글 수 
public class UserProfilePostRespDto {
	List<Post> posts;
	private int commentCount;
}
