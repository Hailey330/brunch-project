package com.project.brunch.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.project.brunch.domain.user.User;

public class NowUserUtilTest {
	
	@Test
	public static void selectUser(User user) {
		
		List<User> users = new ArrayList<>();
		
		
		for (User userList : users) {
			userList.getSnsId();
			userList.getNickName();
			
			users.add(userList);
			System.out.println(users);
		}
	}
}
