package com.sumit.moviecatalogservice.models;

import java.util.ArrayList;
import java.util.List;

public class UserRatedMovies {
	
	private String userId;
	
	
	private List<Rating> userRatedMovies = new ArrayList<Rating>();

	public List<Rating> getUserRatedMovies() {
		return userRatedMovies;
	}

	public void setUserRatedMovies(List<Rating> userRatedMovies) {
		this.userRatedMovies = userRatedMovies;
	}

	
	public UserRatedMovies () {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserRatedMovies(String userId, List<Rating> userRatedMovies) {
		super();
		this.userId = userId;
		this.userRatedMovies = userRatedMovies;
	}
	
	
	

}
