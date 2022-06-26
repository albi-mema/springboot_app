package com.example.demo;

import com.example.demo.Service.SpidService;
import com.example.demo.Service.UserService;
import com.example.demo.Entities.Spid;
import com.example.demo.Entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

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
			"user1@gmail.com"
	);
	User user2 = new User(
			"albin",
			"mema",
			"2",
			"user",
			"pass",
			"user2@gmail.com"
	);
	User user3 = new User(
			"albin",
			"mema",
			"3",
			"user",
			"pass",
			"user3@gmail.com"
	);

	@Test
	public void createUser() {
		User user_ = userService.createUser(user);
		assert (user_ == user);
	}

	@Test
	public void createSpid() {
		Spid spid = spidService.createSpid(user);
	}


	@Test
	public void creatingTwoSpidsFromTheSameUserShouldFail() {
		Spid spid = spidService.createSpid(user2);

		try {
			Spid spid2 = spidService.createSpid(user2);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void getUser(){
		userService.getUser(1L).ifPresent(u -> System.out.println(u));
	}

	@Test
	public void getSpid(){
		spidService.getSpid(1L).ifPresent(s -> System.out.println(s));
	}

	@Test
	public void deleteUser(){
		userService.deleteUser(2L);
	}

	@Test
	public void deleteUserAgainShouldFail() {
		try {
			userService.deleteUser(2L);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void search(){
		List res = userService.serachUserByName("albin");
		System.out.println(res);
	}



}




