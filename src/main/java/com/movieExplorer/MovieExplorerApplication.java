package com.movieExplorer;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movieExplorer.http.ResponseHttp;
import com.movieExplorer.jsonParser.MovieData;

@SpringBootApplication
public class MovieExplorerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(MovieExplorerApplication.class, args);
		
		ResponseHttp test = new ResponseHttp();
		String json = test.movieApiResponse();
		
		MovieData test1 = new MovieData();
		System.out.println(test1.extractMovieInfoFromJson(json));
		
	}

}
