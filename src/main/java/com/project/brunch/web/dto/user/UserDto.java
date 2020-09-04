package com.project.brunch.web.dto.user;

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
	private String snsId;
	private String nickName;
	private String email;
	private String bio; 
	private String profileImage;
	private UserRole userRole;
	private String provider;
	private String providerId;
}
