package com.movieExplorer.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.movieExplorer.dtos.MovieDTO;
import com.movieExplorer.dtos.MovieSearchValueDTO;
import com.movieExplorer.http.RequestHttp;
import com.movieExplorer.jsonParser.MovieData;

@Controller
@RequestMapping(path = "/movies")
public class MovieController {

	@GetMapping
	public ModelAndView getMovies() throws IOException, InterruptedException {
		ModelAndView mv = new ModelAndView("movieExplorer.html");
		return mv;
	}
	
	@PostMapping
	public ModelAndView searchMovie(@RequestParam("searchvalue") MovieSearchValueDTO searchvalue) throws IOException, InterruptedException {
		ModelAndView mv = new ModelAndView("movieExplorer.html");
	    
	    RequestHttp request = new RequestHttp();
	    request.setSearchValue(searchvalue.getSearchValue());
	    
	    MovieData movieData = new MovieData();
	    List<MovieDTO> movies = movieData.extractMovieInfoFromJson();

	    mv.addObject("movies", movies);
	    return mv;
	}
}