package com.example.demo;

import com.example.demo.Service.SpidService;
import com.example.demo.Service.UserService;
import com.example.demo.entities.Spid;
import com.example.demo.entities.Status;
import com.example.demo.entities.Type;
import com.example.demo.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SpringBootDemoApplication.class})
class SpringBootDemoApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private SpidService spidService;

	User user = new User(
			"albin",
			"mema",
			"1",
			"user",
			"pass",
			"@"
	);
	@Test
	public void createUser(){
		userService.createUser(user);
	}
	@Test
	public  void createSpid(){
		Spid spid = spidService.createSpid(user);
		System.out.println(spid);
	}

}
