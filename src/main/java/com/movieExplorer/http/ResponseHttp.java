package com.movieExplorer.http;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class ResponseHttp {

	private ClientHttp client = ClientHttp.INSTANCE;
	private RequestHttp request = new RequestHttp();
	
	public String movieApiResponse() throws IOException, InterruptedException {
		HttpResponse<String> response = client.movieApiClient().send(request.movieApiRequest(), BodyHandlers.ofString());
		return response.body();
	}
	
}
