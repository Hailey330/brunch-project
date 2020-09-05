package com.project.brunch.service;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.config.handler.exception.MyUserIdNotFoundException;
import com.project.brunch.domain.comment.CommentRepository;
import com.project.brunch.domain.follow.FollowRepository;
import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.post.PostMapper;
import com.project.brunch.domain.post.PostRepository;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserMapper;
import com.project.brunch.domain.user.UserRepository;
import com.project.brunch.domain.user.UserRole;
import com.project.brunch.web.dto.user.UserNavProfileRespDto;
import com.project.brunch.web.dto.user.UserProfilePostRespDto;
import com.project.brunch.web.dto.user.UserProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final PostRepository postRepository;
	private final FollowRepository followRepository;
	private final CommentRepository commentRepository;
	
	@Transactional(readOnly = true)
	public UserProfilePostRespDto 상세프로필(int id, LoginUser loginUser) {
		
		// 유저가 쓴 글 목록 + 글 각각에 달린 댓글 수 
		
		// 2-1. 유저가 쓴 글에 달린 댓글 수 가져오기 - 상세 프로필에서 작성 
//		for (Post post : postEntity) {
//			commentCount = commentRepository.mCountByComment(post.getId());
//			System.out.println(post.getId() + "에 달린 댓글 수 : " + commentCount);
//		}
//		
//		UserProfilePostRespDto profilePostEntity = 
//					UserProfilePostRespDto.builder()
//						.posts(postEntity)
//						.commentCount(commentCount)
//						.build();
		
		return null;
	}
	
	@Transactional(readOnly = true)
	public UserProfileRespDto 메인프로필(int id, LoginUser loginUser) {
		
		int followerCount;
		int followingCount;
		int postCount;
		boolean followState;
		
		// 1. 유저 찾기
		User userEntity = userRepository.findById(id)
				.orElseThrow(new Supplier<MyUserIdNotFoundException>() {

			@Override
			public MyUserIdNotFoundException get() {
				return new MyUserIdNotFoundException();
			}
		});
		
		// 2. 유저가 쓴 글 목록 가져오기
		List<Post> postEntity = postRepository.findByUserId(id);
		
		// 3. 유저가 쓴 글 수 카운트
		postCount = postEntity.size();
		
		// 4. 유저를 구독하고 있는 팔로워 수, 유저가 구독하는 팔로잉 수
		followerCount = followRepository.mCountByFollower(id);
		followingCount = followRepository.mCountByFollowing(id);
		System.out.println("유저가 구독하는 작가 수 : " + followerCount);
		System.out.println("유저를 구독하는 작가 수 : " + followingCount);

		// 5. 팔로우 유무 체크
		followState = followRepository.mFollowState(loginUser.getId(), id) == 1 ? true : false;
		System.out.println("팔로우 유무 체크 : " + followState);
		
		UserProfileRespDto userProfileRespDto = 
				UserProfileRespDto.builder()
				.user(userEntity)
				.followerCount(followerCount)
				.followingCount(followingCount)
				.followState(followState)
				.postCount(postCount)
				.build();
		
		return userProfileRespDto;
	}
	
	
	@Transactional
	public User 프로필수정하기(Map<String, Object> data, LoginUser loginUser) {
		
		String bio = (String) data.get("bio");
		String nickName = (String) data.get("nickName");
		String profileImage = (String) data.get("profileImage");
		
		// 1. 유저 찾기 (로그인 유저)
		User user = userRepository.findById(loginUser.getId())
				.orElseThrow(new Supplier<MyUserIdNotFoundException>() {

			@Override
			public MyUserIdNotFoundException get() {
				return new MyUserIdNotFoundException();
			}
		});
		
		// 2. 해당 유저에 정보 업데이트 
		user = User.builder()
				.nickName(nickName)
				.bio(bio)
				.profileImage(profileImage)
				.build();
		
		User userEntity = userMapper.update(user);
		
		return userEntity;
	}

	@Transactional(readOnly = true)
	public UserNavProfileRespDto 로그인유저찾기(LoginUser loginUser) {
		// 1. 유저 찾기
		User userEntity = userRepository.findById(loginUser.getId())
				.orElseThrow(new Supplier<MyUserIdNotFoundException>() {

			@Override
			public MyUserIdNotFoundException get() {
				return new MyUserIdNotFoundException();
			}
		});
		
		// 2. nickName, profileImage 꺼내오기 
		String nickName = userEntity.getNickName();
		String profileImage = userEntity.getProfileImage();
		String bio = userEntity.getBio();
		String userRole = userEntity.getUserRole().getValue();
		
		UserNavProfileRespDto userNavProfileRespDto = 
				UserNavProfileRespDto.builder()
					.nickName(nickName)
					.profileImage(profileImage)
					.bio(bio)
					.userRole(userRole)
					.build();
		
		return userNavProfileRespDto;
	}

}
