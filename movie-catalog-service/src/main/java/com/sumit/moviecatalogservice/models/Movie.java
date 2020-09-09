package com.sumit.moviecatalogservice.models;

public class Movie {
	
	private String movieId;
	private String movieTitle;
	private String movieOverview;
	
	public Movie() {
		
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieOverview() {
		return movieOverview;
	}
	public void setMovieOverview(String movieOverview) {
		this.movieOverview = movieOverview;
	}

	public Movie(String movieId, String movieTitle, String movieOverview) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieOverview = movieOverview;
	}
	

}
