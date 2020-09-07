package com.project.brunch.web.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

	private String title;
	private int id;
	private String nickName;
	private String createDate;
	private String content;
	
}
