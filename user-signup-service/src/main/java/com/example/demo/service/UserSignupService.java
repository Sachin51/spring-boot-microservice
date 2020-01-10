package com.example.demo.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.controller.UserSignupController;
import com.example.demo.model.User;
import com.example.demo.repository.UserSignupRepository;

@Service
public class UserSignupService {

	private Logger LOGGER = Logger.getLogger(UserSignupService.class);

	@Autowired
	UserSignupRepository userSignupRepository;

	public User signupUser(@RequestBody User user) {
		LOGGER.info("In Service-----------------------------------------");
		User userFromDb = null;
		userFromDb = userSignupRepository.findByEmailId(user.getEmailId());
		if (userFromDb == null) {
			LOGGER.info("No existing user hence adding-----------------------------------------" + userFromDb);
			return userSignupRepository.save(user);
		} else {
			LOGGER.info("User already registered-----------------------------------------" + userFromDb.toString());
			return user;
		}
	}
}
