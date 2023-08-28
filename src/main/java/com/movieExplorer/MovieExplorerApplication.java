package com.movieExplorer;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieExplorerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(MovieExplorerApplication.class, args);
		
		
//		MovieData test1 = new MovieData();
//		System.out.println(test1.extractMovieInfoFromJson());
	}
}
