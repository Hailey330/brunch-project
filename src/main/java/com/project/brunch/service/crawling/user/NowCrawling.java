package com.project.brunch.service.crawling.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.project.brunch.domain.user.User;
import com.project.brunch.domain.user.UserRole;

@Service
public class NowCrawling {

	List<User> idList = new ArrayList<>();
	private static String Brunch_URL = "https://brunch.co.kr/";
	private static String userId;
	private static String Id;
	private static String nickName;

	@PostConstruct
	public List<User> getNowCrawling() throws IOException {
		Document doc = Jsoup.connect(Brunch_URL).get();
		Elements elements = doc.select("#mArticle div.wrap_writers ul li a");
		for (Element element : elements) {
			userId = element.attr("href"); // /@Id -> @기준으로 파싱해야함
			int idx = userId.indexOf("@");
			Id = userId.substring(idx + 1);
			nickName = element.select("strong.tit_wirter").text();

			User users = User.builder()
					.snsId(Id)
					.nickName(nickName)
					.userRole(UserRole.USER)
					.build();
			
			idList.add(users);
//			System.out.println(users);
			
		}
		return idList;
	}
}
