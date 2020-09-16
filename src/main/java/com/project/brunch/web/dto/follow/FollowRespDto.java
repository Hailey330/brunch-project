package com.project.brunch.web.dto.follow;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowRespDto {
	private int id;
	private String nickName;
	private String bio;
	private String profileImage;
	private boolean followState;
	private boolean equalUserState;
}
