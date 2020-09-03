package com.project.brunch.web;

import java.util.Date;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.brunch.config.jwt.JwtProperties;
import com.project.brunch.config.oauth.KakaoUserInfo;
import com.project.brunch.config.oauth.OAuth2UserInfo;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.domain.user.UserRole;
import com.project.brunch.web.dto.CommonRespDto;
import com.project.brunch.web.dto.StatusCode;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") 
@RequiredArgsConstructor 
public class JwtCreateController {

	private String TAG = "< JwtCreateController > ";
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private String profileImage = "https://img1.daumcdn.net/thumb/C100x100.fpng/?fname=https://t1.daumcdn.net/brunch/static/img/help/pc/ico_profile_100_01.png";
	
	// 리액트 OAuth2.0 - jwt token 생성 
	@PostMapping("/oauth/jwt/kakao") 
	public String jwtCreateReact(@RequestBody Map<String, Object> data) {
		System.out.println(TAG + "jwtCreateReact() 실행");
		System.out.println(TAG + "data 값 확인 : " + data);
		
		KakaoUserInfo kakaoUser = new KakaoUserInfo((Map<String, Object>)data); 
		
		User userEntity = userRepository.findBySnsId(kakaoUser.getProvider()+"_"+kakaoUser.getProviderId());
		
		if (userEntity == null) {
			User userRequest = User.builder()
					.snsId(kakaoUser.getProvider()+"_"+kakaoUser.getProviderId())
					.email(kakaoUser.getEmail())
					.bio(kakaoUser.getName() + "의 브런치입니다.")
					.profileImage(profileImage)
					.nickName(kakaoUser.getName())
					.provider(kakaoUser.getProvider())
					.providerId(kakaoUser.getProviderId())
					.userRole(UserRole.USER) 
					.build();
			
			userEntity = userRepository.save(userRequest);
		}
		
		String jwtToken = JWT.create()
				.withSubject(userEntity.getSnsId())
				.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
				.withClaim("id", userEntity.getId())
				.withClaim("snsId", userEntity.getSnsId())
				.sign(Algorithm.HMAC512(JwtProperties.SECRET));
		
		System.out.println("Token : " + jwtToken);
		
		return jwtToken;
	}
	
	// 안드로이드 OAuth2.0 - jwt token 생성 
	@PostMapping("/oauth/jwt/kakao/android") 
	public CommonRespDto<?> jwtCreateAndroid(@RequestBody Map<String, Object> data) {
		System.out.println(TAG + "jwtCreateAndroid() 실행");
		System.out.println(TAG + "data 값 확인 : " + data);
		
		KakaoUserInfo kakaoUser = new KakaoUserInfo((Map<String, Object>) data);
		
		User userEntity = userRepository.findBySnsId(kakaoUser.getProvider()+"_"+kakaoUser.getProviderId());
		
		if (userEntity == null) {
			User userRequest = User.builder()
					.snsId(kakaoUser.getProvider()+"_"+kakaoUser.getProviderId())
					.email(kakaoUser.getEmail())
					.bio(kakaoUser.getName() + "의 브런치입니다.")
					.profileImage(profileImage)
					.nickName(kakaoUser.getName())
					.provider(kakaoUser.getProvider())
					.providerId(kakaoUser.getProviderId())
					.userRole(UserRole.USER) 
					.build();
			
			userEntity = userRepository.save(userRequest);
		}
		
		String jwtToken = JWT.create()
				.withSubject(userEntity.getSnsId())
				.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
				.withClaim("id", userEntity.getSnsId())
				.withClaim("snsId", userEntity.getSnsId())
				.sign(Algorithm.HMAC512(JwtProperties.SECRET));
		
		CommonRespDto<?> respDto = CommonRespDto.builder()
				.statusCode(StatusCode.OK)
				.data(jwtToken)
				.build();
		
		return respDto;
	}
	
}
