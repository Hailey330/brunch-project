package com.project.brunch.test;

public class NowUtilTest {
	
	public static String increase(String input) {
		int temp = Integer.parseInt(input);
		temp++;
		String s = String.format("%03d", temp);
		return s;
	}
}
