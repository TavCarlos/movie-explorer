package com.movieExplorer.dtos;

public record MovieDTO(String name, double relevance, String type, int id, int year, String result_type, int tmdb_id, String tmdb_type, String image_url) {

}
