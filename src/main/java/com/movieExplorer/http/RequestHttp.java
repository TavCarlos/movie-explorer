package com.movieExplorer.http;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;

public class RequestHttp {

	private String url;
	
	public HttpRequest movieApiRequest() {
		System.out.println(url);
		return HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(url))
				.timeout(Duration.ofSeconds(30))
				.build();
	}
}
