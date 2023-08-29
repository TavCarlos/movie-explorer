package com.movieExplorer.jsonParser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieExplorer.dtos.MovieDTO;
import com.movieExplorer.dtos.MovieResultDTO;
import com.movieExplorer.http.ResponseHttp;

@Component
public class MovieData {
	
	@Autowired
	private ResponseHttp response;
	private ObjectMapper objectMapper = getDefaultObjectMapper();
	private List<MovieDTO> movies = new ArrayList<>();
	
	private ObjectMapper getDefaultObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}
	
	 MovieResultDTO jsonToJava()  {
		String json = response.movieApiResponse();
		try {
			return objectMapper.readValue(json, MovieResultDTO.class);
		} catch (JsonProcessingException error) {
			throw new RuntimeException("An error occurred while processing the JSON" + error.getMessage());
		}
	}
	
	public List<MovieDTO> extractMovieInfoFromJson()  {
		String json = response.movieApiResponse();
		JsonNode jsonNode;
		movies.clear();
		
		try {
			jsonNode = objectMapper.readTree(json);
			JsonNode results = jsonNode.get("results");
			
			for(JsonNode result: results) {
				String name = result.get("name").asText();
				String type = result.get("type").asText();
				String year = result.get("year").asText();
				String imageUrl = result.get("image_url").asText();
				
				if(!imageUrl.contains("/profiles/") && !imageUrl.contains("null")) {
					movies.add(new MovieDTO(name, type, year, imageUrl));	
				}
			}
		} catch (JsonProcessingException error) {
			throw new RuntimeException("Erro ao processar JSON" + error.getMessage());
		}
		
		return movies;
	}
	
}
