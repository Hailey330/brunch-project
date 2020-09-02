package com.project.brunch.web.dto.admin;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDto {

	private int allUserCount;
	private int allPostCount;
	private int todayPostCount;
	
	private int rank;
	private String nickName;
	private String title;
	private int readCount;
	private Timestamp createDate;
	
}
