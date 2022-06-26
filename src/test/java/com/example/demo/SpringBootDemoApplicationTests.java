package com.example.demo;

import com.example.demo.Service.SpidService;
import com.example.demo.Service.UserService;
import com.example.demo.entities.Spid;
import com.example.demo.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
		Spid spid = spidService.createSpid(user);

		try {
			Spid spid2 = spidService.createSpid(user);
		} catch (Exception e) {
			System.out.println(e);
		}
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

}




