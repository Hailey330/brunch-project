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

public class UserProfilePostRespDto {
	List<Post> posts;
	private int commentCount;
}
