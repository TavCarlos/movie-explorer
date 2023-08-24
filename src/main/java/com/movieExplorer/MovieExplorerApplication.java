package com.movieExplorer;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movieExplorer.http.ResponseHttp;

@SpringBootApplication
public class MovieExplorerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(MovieExplorerApplication.class, args);
		
		ResponseHttp test = new ResponseHttp();
		System.out.println(test.movieApiResponse());
	}

}
