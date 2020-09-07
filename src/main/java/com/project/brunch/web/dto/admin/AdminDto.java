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
	private boolean mainControll;
	
	private int rank;
	private int numberCount;
	private String nickName;
	private String title;
	private String subTitle;
	private int readCount;
	private Timestamp createDate;
	private boolean mainPost;
	
	private int likeCount;
	private int userId;
	private int postId;
	private int id;
	
}
