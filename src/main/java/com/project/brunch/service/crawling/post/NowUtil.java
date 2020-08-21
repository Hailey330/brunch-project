package com.project.brunch.service.crawling.post;

import org.springframework.stereotype.Component;

@Component
public class NowUtil {
	
	public static String increase(String input) {
		int temp = Integer.parseInt(input);
		temp++;
		String s = String.format("%03d", temp);
		return s;
	}
}
