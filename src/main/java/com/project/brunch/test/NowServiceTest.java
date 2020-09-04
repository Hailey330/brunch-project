package com.project.brunch.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.brunch.domain.post.Post;
import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRepository;

public class NowServiceTest {

	private static String postId = "1";
	private static String host = "https://brunch.co.kr/";
	private static String URL;
	private static Elements element;
	private static Elements elCover;
	private static Elements elBody;
	private static Elements elWriter;
	private static Post post;


	
	@Test
	public void getBrunchDatas() throws IOException {

		List<Post> postList = new ArrayList<>();
		
		
		while (true) {
			URL = host + "@dan507/" + postId;
			Document doc = Jsoup.connect(URL).get();
			element = doc.select(".wrap_view_article");
			elCover = element.select(".wrap_cover");
			elBody = element.select(".wrap_body");
			elWriter = element.select("#wrapArticleInfo");

			String title = elCover.select("h1.cover_title").text(); // title
			String subTitle = elCover.select("p.cover_sub_title").text(); // subTitle
//			String nickname = elWriter.select("span.text_author").text();

			postId = NowUtilTest.increase(postId);

			String content = elBody.select("h4").text();
			Elements picture = elBody.select(".wrap_img_float img[src]");
			for (Element pics : picture) {
				String pic = pics.attr("src");
				System.out.println("사진 ::: " + pic);
			}

			post = Post.builder().title(title).subTitle(subTitle).content(content).build();
			postList.add(post);

			System.out.println(postList);
		}
	}

}
