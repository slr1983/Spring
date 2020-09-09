package com.sumit.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.ratingsdataservice.models.Rating;
import com.sumit.ratingsdataservice.models.UserRatedMovies;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId, 5);
		
	}
	
	
	
	@RequestMapping("users/{userId}")
	public UserRatedMovies getUserRatedMovies(@PathVariable("userId") String userId) {
		
		List<Rating> ratings = Arrays.asList(new Rating("111", 3), new Rating("222", 4));
		
		UserRatedMovies userRatedMovies =  new UserRatedMovies();
		
		userRatedMovies.setUserRatedMovies(ratings);
		
		userRatedMovies.setUserId(userId);
		
		return userRatedMovies;
		
		
	}

}
