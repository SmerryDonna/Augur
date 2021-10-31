package com.cryptoproject.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.augur.client.APIClient;
import com.augur.client.MessaggioClient;
import com.coinmarketapi.models.ApiResponse;
import com.cryptoproject.graph.InterGraph;
import com.cryptoproject.graph.LogInGraph;
import com.cyptoproject.login.Login;

public class ControllerUIModel {

	private InterGraph inter;
	private LogInGraph login;
	private MessaggioClient messaggioClient;

	private ActionListener gestoreSubmitInter;
	private ActionListener gestoreSubmitLogin;

	private String indirizzoProtafoglio;
	private String previsione;
	private String valuta;
	private String scommessa;
	private APIClient apiClient;

	private Login loginAuth;

	private String username;
	private String psw;

	public ControllerUIModel(InterGraph inter, LogInGraph login, MessaggioClient messaggioClient, APIClient apiClient) {
		this.inter = inter;
		this.login = login;
		this.messaggioClient = messaggioClient;
		this.apiClient = apiClient;
		gestoreEventi();

		// assegno il gestore di evento al bottone btnSubmit dell'interfaccia
		inter.getBtnSubmit().addActionListener(gestoreSubmitInter);

		login.getBtnSubmit().addActionListener(gestoreSubmitLogin);
	}

	private void gestoreEventi() {
		// Codice gestore dell'interfaccia grafica autenticata
		gestoreSubmitInter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				messaggioClient.setIndirizzoPortafoglio(inter.getPortafoglio());
				messaggioClient.setPrevisione(inter.getPrevisione());
				messaggioClient.setValuta(inter.getValuta());
				messaggioClient.setScommessa(inter.getScommessa());

				// chiamata al metodo API
				ApiResponse<String> apiResponse = apiClient.getAnswerFromServer(messaggioClient);
				if (apiResponse.getData().equals("OK")) {
					inter.setVintoPerso("Hai vinto!");
				} else if (apiResponse.getData().equals("KO")) {
					inter.setVintoPerso("Hai perso tutto!");
				}

			}

		};

		// Codice gestore dell'interfaccia di login
		gestoreSubmitLogin = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginAuth.setUsername(login.getUsername());
				loginAuth.setPassword(login.getPsw());
			}
		};

	}

}
