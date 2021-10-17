package com.coinmarketapi;

import com.coinmarketapi.models.ApiResponse;

public class App {
	public static void main(String[] args) {
		ApiResponse<Double> response = ApiManager.getBitcoinPrice();

		if (response.getSuccess()) {
			System.out.println("Il prezzo di Bitcoin e' di: " + response.getData() + " euro");
		} else {
			System.out.println("E' andato tutto MALE");
		}
	}
}
