package com.project.brunch.config.auth.dto;

import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRole;

import lombok.Data;

@Data
public class LoginUser {
	private int id;
	private String snsId;
	private String nickName;
	private String email;
	private UserRole userRole;
	private String provider;
	private String providerId;
	private String profileImage;
	private String bio;

	public LoginUser(User user) {
		this.id = user.getId();
		this.snsId = user.getSnsId();
		this.nickName = user.getNickName();
		this.email = user.getEmail();
		this.userRole = user.getUserRole();
		this.provider = user.getProvider();
		this.providerId = user.getProviderId();
		this.profileImage = user.getProfileImage();
		this.bio = user.getBio();
	}
	
	public User getUser() {
		return User.builder().id(id).build();
	}

}