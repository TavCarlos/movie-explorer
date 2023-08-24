package com.movieExplorer.http;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.time.Duration;

public enum ClientHttp {
	INSTANCE;
	
	public HttpClient movieApiClient() {
		return HttpClient.newBuilder()
		.connectTimeout(Duration.ofSeconds(30))
		.followRedirects(Redirect.NORMAL)
		.build();
	}
	
}
