package com.project.brunch.web.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminSearchDto {
	private int id;
	private int userId;
	private String snsId;
	private String nickName;
	private String email;
	private String keyword;
	private String title;
	private String userRole;
	private String createDate;
}
