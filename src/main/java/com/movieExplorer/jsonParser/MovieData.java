package com.movieExplorer.jsonParser;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieExplorer.dtos.MovieDTO;
import com.movieExplorer.dtos.MovieResultDTO;

public class MovieData {

	private ObjectMapper objectMapper = getDefaultObjectMapper();
	private List<MovieDTO> movies = new ArrayList<>();
	
	
	private ObjectMapper getDefaultObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}
	
	public MovieResultDTO jsonToJava(String json) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readValue(json, MovieResultDTO.class);
	}
	
	
	public List<MovieDTO> extractMovieInfoFromJson(String json) throws JsonMappingException, JsonProcessingException {
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
	
}
