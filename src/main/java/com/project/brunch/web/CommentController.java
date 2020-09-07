package com.project.brunch.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.config.auth.LoginUserAnnotation;
import com.project.brunch.config.auth.dto.LoginUser;
import com.project.brunch.domain.comment.Comment;
import com.project.brunch.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch")
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentService commentService;
	
	// 댓글 뿌리기 
	@GetMapping("/post/comment/{postId}")
	public List<Comment> getComment(@PathVariable int postId) {

		return commentService.댓글뿌리기( postId);
	}
	
	// 댓글 저장
	@PostMapping("/post/commentSave/{postId}")
	public @ResponseBody String commentSave(@RequestBody Comment comment, @PathVariable int postId, @LoginUserAnnotation LoginUser loginUser) {
		commentService.댓글저장(comment, loginUser, postId);
		
		return "댓글저장완료";
	}
}
