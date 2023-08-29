package com.movieExplorer.dtos;

public class MovieSearchValueDTO {

	private String searchvalue;
	
	public MovieSearchValueDTO() {
	}
	
	public MovieSearchValueDTO(String searchvalue) {
		this.searchvalue = searchvalue;
	}
	
	
	public String getSearchValue() {
		return searchvalue;
	}
	
	public void setSearchValue(String searchvalue) {
		this.searchvalue = searchvalue;
	}
}
