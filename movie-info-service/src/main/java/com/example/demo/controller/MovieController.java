package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@GetMapping("/{movieId}")
	public List<Movie> getAllMovies(@PathVariable String movieId) {

		return Collections.singletonList(new Movie("M1", "Transformers"));
	}
}
