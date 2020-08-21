package com.project.brunch.test.service.crawling.post;

public class NowUtilTest {
	
	public static String increase(String input) {
		int temp = Integer.parseInt(input);
		temp++;
		String s = String.format("%03d", temp);
		return s;
	}
}
