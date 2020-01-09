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
import com.example.demo.service.MovieInfoService;
import com.example.demo.service.RatingsInfoService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	MovieInfoService movieInfoService;

	@Autowired
	RatingsInfoService ratingsInfoService;

	private static Logger LOGGER = Logger.getLogger(MovieCatalogController.class);

	@GetMapping(value = "/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		// List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new
		// Rating("1234", 4));

		UserRatings ratings = ratingsInfoService.getUserRatings(userId);
		// UserRatings ratings =
		// restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId,
		// UserRatings.class);
		return ratings.getUserRating().stream().map(rating -> {

			Movie movie = movieInfoService.getMovieInfo(rating.getMovieId());
			// Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" +
			// rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "Test", rating.getRating());
		}).collect(Collectors.toList());

	}
}

//Fault tolerance means given an appliaction having a fault, how much impact does it have on the application.
//ex:A service going down

//Resilience means how many faults a system can tolerate before it goes down, also means how much can a system bounce back.
//Is there a mechanism by which the system can bounce back.

//Hystrix is a open source library implemented by Netflix
//Hystrix implements circuit breaker pattern