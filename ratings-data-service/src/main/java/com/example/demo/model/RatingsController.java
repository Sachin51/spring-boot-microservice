package com.example.demo.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {

	@GetMapping(value = "/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating("M1", 4);
	}
}
