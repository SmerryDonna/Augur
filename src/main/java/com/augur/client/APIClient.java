package com.augur.client;

import static spark.Spark.stop;

import java.net.URI;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.coinmarketapi.models.ApiResponse;

public class APIClient {

	private MessaggioClient messaggioClient;
	private String urlBase = "http://localhost:4567/api/v1.0/";

	public APIClient(MessaggioClient messaggioClient) {
		this.messaggioClient = messaggioClient;
	}

	private ApiResponse<String> getAnswers() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			Map map = restTemplate.postForObject(new URI(urlBase), this.messaggioClient, Map.class);
			if (map != null && map.containsKey("data") && map.containsKey("success")) {
				return new ApiResponse<String>((boolean) map.get("success"), (String) map.get("data"));
			} else {
				return new ApiResponse<String>(false, null);
			}
		} catch (Exception ignored) {
			System.out.println("Errore nella ricezione delle informazioni.");
			return new ApiResponse<String>(false, null);
		}
	}

	public static ApiResponse<String> getAnswerFromServer(MessaggioClient messaggioClient) {
		// MessaggioClient messaggioClient = new MessaggioClient("dg234h56jhgf789hjkx0",
		// "5", "BTC", "23000");
		APIClient apiClient = new APIClient(messaggioClient);
		ApiResponse<String> apiResponse = apiClient.getAnswers();
		stop();
		return apiResponse;
	}

}