package com.project.brunch.web.dto.post;

import java.security.Timestamp;

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
	private String nickName;
	private String coverImg;
	private Timestamp createDate;
}
