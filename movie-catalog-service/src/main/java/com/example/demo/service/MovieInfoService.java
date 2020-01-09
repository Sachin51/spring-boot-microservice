package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfoService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getMovieInfoFallback")
	public Movie getMovieInfo(String movieId) {
		return restTemplate.getForObject("http://localhost:8082/movie/" + movieId, Movie.class);
	}

	public Movie getMovieInfoFallback(String movieId) {
		return new Movie("0", "Movie Not Found", "Fallback Working");
	}
}
