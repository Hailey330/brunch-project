package com.project.brunch.service.crawling.post;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.brunch.domain.post.Post;

@Service
public class CoverImgParser {

	@Autowired
	private ImgService imgService;
	
	public void getCoverImg() throws IOException {
		
//		List<Post> cover = imgService.사진불러오기(subtitle)
	}
}
