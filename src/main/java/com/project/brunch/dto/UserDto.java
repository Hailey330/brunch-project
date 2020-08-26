package com.project.brunch.dto;

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
	
//	public User toEntity() {
//		User build = User.builder()
//				.id(id)
//				.password(password)
//				.nickName(nickName)
//				.email(email)
//				.bio(bio)
//				.snsId(snsId)
//				.profileImage(profileImage)
//				.userRole(userRole.USER)
//				.provider(provider)
//				.providerId(providerId)
//				.build();
//		
//		return build;
//	}
//	
//	@Builder
//	public UserDto(int id, String snsId, String profileImage, String nickName, UserRole userRole) {
//		this.id = id;
//		this.snsId = snsId;
//		this.profileImage = profileImage;
//		this.nickName = nickName;
//		this.userRole = userRole;
//	}
}
