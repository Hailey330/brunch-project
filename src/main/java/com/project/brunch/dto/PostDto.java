package com.project.brunch.dto;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class PostDto {
	
	private int id;
	private String title;
	private String content;
	private String nickName;
}
