package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.iddouble.MyUser;
import com.example.demo.iddouble.MyUserService;

@SpringBootTest
public class Util007_IdDouble {
	@Autowired MyUserService myUserService;
	
	@Disabled @Test void userInsert() {
		MyUser user = new MyUser();
//		user.setUsername("first");
//		user.setEmail("first@gmail.com");
		//user.setUsername("second");
		//user.setEmail("second@gmail.com");
		System.out.println(myUserService.insertUser(user));
	}
	
	@Disabled @Test void userSelect() { System.out.println(myUserService.selectUserEmail("first@gmail.com")); }
	@Disabled @Test void userSelectUsername() {
		System.out.println(myUserService.selectUserName("first"));
	}
}
