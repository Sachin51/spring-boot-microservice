package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Rating;
import com.example.demo.model.UserRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingsInfoService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getUserRatingsFallback")
	public UserRatings getUserRatings(String userId) {
		return restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRatings.class);
	}

	public UserRatings getUserRatingsFallback(String userId) {
		UserRatings userRatings = new UserRatings();
		userRatings.setUserId(userId);
		userRatings.setUserRating(Arrays.asList(new Rating("0", 0)));
		return userRatings;
	}
}
