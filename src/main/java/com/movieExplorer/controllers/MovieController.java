package com.movieExplorer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private RequestHttp request;
	
	@Autowired
	private MovieData movieData;
	
	@GetMapping
	public ModelAndView getMovies() {
		ModelAndView mv = new ModelAndView("movieExplorer.html");
		return mv;
	}
	
	@PostMapping
	public ModelAndView searchMovie(@RequestParam("movieSearchParam") MovieSearchValueDTO movieSearchParam)  {
		ModelAndView mv = new ModelAndView("movieExplorer.html");
	    
	    request.setSearchValue(movieSearchParam.getMovieSearchParam());
	    List<MovieDTO> movies = movieData.extractMovieInfoFromJson();

	    mv.addObject("movies", movies);
	    return mv;
	}
}