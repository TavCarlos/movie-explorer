package com.movieExplorer.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movieExplorer.dtos.MovieDTO;
import com.movieExplorer.jsonParser.MovieData;

@Controller
@RequestMapping(path = "/moviexplorer")
public class MovieController {

	@GetMapping
	public ModelAndView getMovies() throws IOException, InterruptedException {
		ModelAndView mv = new ModelAndView("movieExplorer");
		MovieData movieData = new MovieData();
		
		movieData.extractMovieInfoFromJson();
		List<MovieDTO> movies = movieData.getMovies();
		
		mv.addObject("movies", movies);
		return mv;
	}
}
