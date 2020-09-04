package com.project.brunch.web.dto.admin;


import java.sql.Timestamp;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.user.User;

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
	private int numberCount = getadminDto();
	private String nickName;
	private String title;
	private int readCount;
	private Timestamp createDate;
	
	private int likeCount;
	private int userId;
	private int postId;
	
	// 수정중
	public int getadminDto() {
		int numberCount = this.numberCount;
		for (int i = 1; i < 6; i++) {
			numberCount = i;
			System.out.println(numberCount);
		}
		return numberCount;
	}
}
