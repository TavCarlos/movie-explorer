package com.movieExplorer.http;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.time.Duration;

import org.springframework.stereotype.Component;

@Component
public class ClientHttp {
	
	public HttpClient movieApiClient() {
		return HttpClient.newBuilder()
		.connectTimeout(Duration.ofSeconds(30))
		.followRedirects(Redirect.NORMAL)
		.build();
	}
	
}
