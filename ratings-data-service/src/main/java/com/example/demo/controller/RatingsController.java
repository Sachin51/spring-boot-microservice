package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Rating;
import com.example.demo.model.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {

	@GetMapping(value = "/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating("M1", 4);
	}

	@GetMapping("users/{userId}")
	public UserRatings getUserRatings(@PathVariable String userId) {
		List<Rating> ratings = Arrays.asList(new Rating(Integer.toString((int) (10.0 * Math.random())), (int) (10.0 * Math.random())),
				new Rating(Integer.toString((int) (10.0 * Math.random())), (int) (10.0 * Math.random())));
		UserRatings userRatings = new UserRatings();
		userRatings.setUserRating(ratings);
		return userRatings;
	}
}
