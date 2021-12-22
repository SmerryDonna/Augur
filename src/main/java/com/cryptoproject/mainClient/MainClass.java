package com.cryptoproject.mainClient;

import com.augur.client.APIClient;
import com.augur.client.MessaggioClient;
import com.coinmarketapi.ApiManager;
import com.coinmarketapi.models.ApiResponse;
import com.cryptoproject.controller.ControllerUIModel;
import com.cryptoproject.graph.InterGraph;
import com.cryptoproject.graph.LogInGraph;

@SuppressWarnings("unused, FieldCanBeLocal, SpellCheckingInspection")
public class MainClass {
	/**
	 * Il metodo Main e' il cuore del gioco, fa partire tutto il modello MVC
	 *
	 * @param args e' un parametro preimpostato
	 */
	public static void main(String[] args) {
		// invocazione metodi di SWING tramite thread, usando la SWING utility sopra
		ApiResponse<Double> response = ApiManager.getBitcoinPrice();
		String bit = String.valueOf(response.getData());
		MessaggioClient messaggioClient = new MessaggioClient("2345667893djdjbfe8393", bit, "BTC", "23");
		ApiResponse<String> apiResponse = APIClient.getAnswerFromServer(messaggioClient);
		System.out.println(apiResponse.getData());
		System.out.println(apiResponse.getSuccess());
		LogInGraph login = new LogInGraph();
		InterGraph interGraph = new InterGraph();
		ControllerUIModel gestoreUI = new ControllerUIModel(interGraph, login, messaggioClient);
	}
}
