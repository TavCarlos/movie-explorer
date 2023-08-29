package com.movieExplorer.dtos;

public class MovieSearchValueDTO {

	private String movieSearchParam;
	
	public MovieSearchValueDTO() {
	}
	
	public MovieSearchValueDTO(String movieSearchParam) {
		this.movieSearchParam = movieSearchParam;
	}
	
	
	public String getMovieSearchParam() {
		return movieSearchParam;
	}
	
	public void setMovieSearchParam(String movieSearchParam) {
		this.movieSearchParam = movieSearchParam;
	}
}
