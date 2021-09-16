package com.augur.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.coinmarketapi.ApiManager;
import com.coinmarketapi.models.ApiResponse;

@ComponentScan
@SpringBootApplication
public class AugurApplication {

	public static void main(String[] args) {

		ApiResponse<Double> response = ApiManager.getBitcoinPrice();

		if (response.getSuccess()) {
			System.out.println("Il prezzo di Bitcoin e' di: " + response.getData() + " euro");
		} else {
			System.out.println("E' andato tutto in vacca");
		}
		SpringApplication.run(AugurApplication.class, args);
	}
}
