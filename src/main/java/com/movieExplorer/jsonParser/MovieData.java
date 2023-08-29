package com.movieExplorer.jsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieExplorer.dtos.MovieDTO;
import com.movieExplorer.dtos.MovieResultDTO;
import com.movieExplorer.http.ResponseHttp;


public class MovieData {
	
	private ResponseHttp response = new ResponseHttp();
	private ObjectMapper objectMapper = getDefaultObjectMapper();
	private List<MovieDTO> movies = new ArrayList<>();
	
	
	private ObjectMapper getDefaultObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}
	
	private String getHttpResponseJson() throws IOException, InterruptedException {
		return response.movieApiResponse();
	}
	
	public MovieResultDTO jsonToJava() throws IOException, InterruptedException {
		String json = this.getHttpResponseJson();
		return objectMapper.readValue(json, MovieResultDTO.class);
	}
	
	
	public List<MovieDTO> extractMovieInfoFromJson() throws IOException, InterruptedException {
		String json = this.getHttpResponseJson();
		
		JsonNode jsonNode = objectMapper.readTree(json);
		JsonNode results = jsonNode.get("results");
		
		for(JsonNode result: results) {
			String name = result.get("name").asText();
			String type = result.get("type").asText();
			String year = result.get("year").asText();
			String imageUrl = result.get("image_url").asText();
			
			MovieDTO movie = new MovieDTO(name, type, year, imageUrl);
			movies.add(movie);
		}
		return movies;
	}

	public List<MovieDTO> getMovies() {
		return movies;
	}
	
}
