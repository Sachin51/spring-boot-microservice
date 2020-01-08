package com.example.demo.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieSummary;

@RestController
@RequestMapping("/movie")
public class MovieController {

	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.key}")
    private String apiKey;
	
	private static Logger LOGGER = Logger.getLogger(MovieController.class);

	@GetMapping("/{movieId}")
	public Movie getAllMovies(@PathVariable String movieId) {
		
		LOGGER.info("Movie Id:------------------------"+movieId);
		MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

		//return Collections.singletonList(new Movie("M1", "Transformers"));
	}
}
