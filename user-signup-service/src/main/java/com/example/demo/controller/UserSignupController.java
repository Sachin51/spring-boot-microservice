package com.example.demo.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserSignupService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserSignupController {

	@Autowired
	UserSignupService userService;

	private Logger LOGGER = Logger.getLogger(UserSignupController.class);

	@PostMapping(value = "/signup")
	public User signupUser(@RequestBody User user) {
		LOGGER.info("User object is: ----------------------------"+user.toString());
		return userService.signupUser(user);
	}
}
