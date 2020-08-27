package com.project.brunch.config.auth.provider;

import java.util.Map;
import java.util.Properties;

public class KakaoUserInfo implements OAuth2UserInfo {

	private Map<String, Object> attributes;
	
	public KakaoUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	@Override
	public String getProviderId() {
		System.out.println("getProviderId : "+ attributes.get("id"));
		return String.valueOf(attributes.get("id"));
	}

	@Override
	public String getProvider() {
		return "kakao";
	}

	@Override
	public String getEmail() {
		Map<String, Object> kakao_account =(Map<String, Object>) attributes.get("kakao_account");
		System.out.println("email : " + kakao_account.get("email"));
		return String.valueOf(kakao_account.get("email"));
//		System.out.println("getEmail : "+ attributes.get("email"));
//		return String.valueOf(attributes.get("profile"));
	}

	@Override
	public String getName() {
		Map<String, Object> nickname = (Map<String, Object>) attributes.get("properties");
		System.out.println("nickname : " + nickname.get("nickname"));
		return String.valueOf(nickname.get("nickname"));
//		System.out.println("getName : "+ attributes.get("nickname"));
//		return String.valueOf(attributes.get("nickname"));
	}

}
