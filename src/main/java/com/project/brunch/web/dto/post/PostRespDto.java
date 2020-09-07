package com.project.brunch.web.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class PostRespDto {
	
	private int id;
	private String title;
	private String content;
	private String subTitle;
	private String nickName;
	private String coverImg;
	private String profileImage;
	private String tag;
	private String createDate;
}
