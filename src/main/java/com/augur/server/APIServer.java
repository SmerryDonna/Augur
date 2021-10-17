package com.augur.server;

import static spark.Spark.before;
import static spark.Spark.halt;
import static spark.Spark.post;

import java.util.Map;

import com.coinmarketapi.ApiManager;
import com.coinmarketapi.models.ApiResponse;
import com.google.gson.Gson;

public class APIServer {

	// get che riceve la post del client
	public static void main(String[] args) {
		String urlBase = "/api/v1.0/";
		Gson gson = new Gson();

		before((request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			response.header("Access-Control-Allow-Headers", "Content-Type");
		});

		post(urlBase, "application/json", (request, response) -> {
			Map result = gson.fromJson(request.body(), Map.class);
			if (result != null && result.containsKey("indirizzoPortafoglio") && result.containsKey("scommessa")
					&& result.containsKey("previsione") && result.containsKey("valuta")) {
				MessaggioServer messaggioServer;
				messaggioServer = new MessaggioServer((String) result.get("indirizzoPortafoglio"),
						(String) result.get("scommessa"), (String) result.get("valuta"),
						(String) result.get("previsione"));
				ApiResponse<Double> responseBitcoinPrice = ApiManager.getBitcoinPrice();
				if (responseBitcoinPrice.getSuccess()) {
					double valore = responseBitcoinPrice.getData();
					response.type("application/json");
					response.status(200);
					if (valore == Double.parseDouble(messaggioServer.getScommessa())) {
						// return "OK";
						return new ApiResponse<String>(true, "OK");
					} else {
						// return "KO";
						return new ApiResponse<String>(false, "KO");
					}
				} else {
					halt(500);
				}
			} else {
				halt(500);
			}
			return "";
		}, gson::toJson);
	}
}
