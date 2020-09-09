package com.sumit.moviecatalogservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sumit.moviecatalogservice.models.Rating;
import com.sumit.moviecatalogservice.models.UserRatedMovies;

@Service
public class UserRatingInfoService {
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRatedMovies getUserRating(String userId) {

		return restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/users/" + userId,
				UserRatedMovies.class);

	}

	public UserRatedMovies getFallbackUserRating(String userId) {

		UserRatedMovies userRatedMovies = new UserRatedMovies();
		userRatedMovies.setUserId(userId);
		userRatedMovies.setUserRatedMovies(Arrays.asList(new Rating("0", 0)));

		return userRatedMovies;

	}

}
