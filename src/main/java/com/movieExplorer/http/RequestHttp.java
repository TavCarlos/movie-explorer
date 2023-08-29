package com.movieExplorer.http;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RequestHttp {

	@Value("${api.key}")
	private String apiKey;
	private String baseUrl = "https://api.watchmode.com/v1/autocomplete-search/";
	private static String searchValue;
	
	public HttpRequest movieApiRequest(){
		return HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(this.getUrlWithSearchValue()))
				.timeout(Duration.ofSeconds(30))
				.build();
	}
	
	public String getUrlWithSearchValue() {
		String value = searchValue.replace(" ", "%20");
		return baseUrl + "?apiKey=" + apiKey + "&search_value=" + value;
	}
	
	public void setSearchValue(String value) {
		searchValue = value;
	}
}
