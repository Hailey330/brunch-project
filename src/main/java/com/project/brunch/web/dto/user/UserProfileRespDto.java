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
}
