package com.sumit.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.moviecatalogservice.models.CatalogItem;
import com.sumit.moviecatalogservice.models.UserRatedMovies;
import com.sumit.moviecatalogservice.services.MovieInfoService;
import com.sumit.moviecatalogservice.services.UserRatingInfoService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	// @Autowired
	// private WebClient.Builder webClientBuilder;

	@Autowired
	private MovieInfoService movieInfoService;

	@Autowired
	private UserRatingInfoService userRatingInfoService;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRatedMovies userRatedMovies = userRatingInfoService.getUserRating(userId);

		return userRatedMovies.getUserRatedMovies().stream().map(rating -> {

			return movieInfoService.getCatalogItem(rating);

		}).collect(Collectors.toList());

	}

}
