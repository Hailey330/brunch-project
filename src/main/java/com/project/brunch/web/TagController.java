package com.project.brunch.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.brunch.domain.tag.Tag;
import com.project.brunch.domain.tag.TagRepository;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "/*")
@RequestMapping("brunch") 
@RequiredArgsConstructor
public class TagController {

	private final TagRepository tagRepository;

	// 태그 불러오기 - 전체 태그 목록
	@GetMapping("/tag/list")
	public List<Tag> tagList() {
		List<Tag> test = tagRepository.findAll();
		return tagRepository.findAll();
	}

	// 태그 저장하기
	@PostMapping("/tag/save")
	public Tag tagSave(@RequestBody Tag tag) {
		return tagRepository.save(tag);
	}

}
