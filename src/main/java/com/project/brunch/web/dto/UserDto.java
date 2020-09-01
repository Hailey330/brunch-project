package com.project.brunch.web.dto;

import com.project.brunch.domain.user.UserRole;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UserDto {

	private int id;
	private String password;
	private String snsId; // @앞 아이디 파싱한거
	private String nickName;
	private String email;
	private String bio; 
	private String profileImage;
	private UserRole userRole;
	private String provider;
	private String providerId;
}
