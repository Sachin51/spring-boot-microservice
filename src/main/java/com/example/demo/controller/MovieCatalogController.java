package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CatalogItem;
import com.example.demo.model.Movie;
import com.example.demo.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	RestTemplate restTemplate;
	
	private static Logger LOGGER = Logger.getLogger(MovieCatalogController.class);

	@GetMapping(value = "/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		//List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("1234", 4));
		
		UserRatings ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRatings.class);

		return ratings.getUserRating().stream().map(rating -> {
			LOGGER.info("Ratings: -------------------------------------"+rating.toString());
			Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" + rating.getMovieId(), Movie.class);
			LOGGER.info("Working movie: -------------------------------------"+movie);
			return new CatalogItem(movie.getName(), "Test", rating.getRating());
		}).collect(Collectors.toList());

	}
}
