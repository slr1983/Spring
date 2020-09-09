package com.sumit.moviecatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sumit.moviecatalogservice.models.CatalogItem;
import com.sumit.moviecatalogservice.models.Movie;
import com.sumit.moviecatalogservice.models.Rating;

@Service
public class MovieInfoService {
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);

		/*
		 * Movie movie = webClientBuilder.build() .get()
		 * .uri("http://localhost:8882/movies/" + rating.getMovieId()) .retrieve()
		 * .bodyToMono(Movie.class) .block();
		 */

		return new CatalogItem(movie.getMovieTitle(), movie.getMovieOverview(), rating.getRating());

	}

	public CatalogItem getFallbackCatalogItem(Rating rating) {
		
		CatalogItem catalogItem = new CatalogItem("Movie Name not found", "", rating.getRating());

		return catalogItem;

	}

}
