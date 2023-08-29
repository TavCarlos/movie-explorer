package com.movieExplorer.http;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseHttp {

	@Autowired
	private RequestHttp request;
	
	@Autowired
	private ClientHttp client;
	
	public String movieApiResponse() {
		try {
			HttpResponse<String> response = client.movieApiClient().send(request.movieApiRequest(), BodyHandlers.ofString());
			return response.body();
		
		} catch (IOException error) {
			return "File not found" + error.getMessage();
		} catch (InterruptedException error) {
			Thread.currentThread().interrupt();
			return "Request Interrupted";
		}
	}
	
}
