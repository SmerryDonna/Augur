package com.cryptoproject.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import com.augur.client.APIClient;
import com.augur.client.MessaggioClient;
import com.coinmarketapi.models.ApiResponse;
import com.cryptoproject.graph.InterGraph;
import com.cryptoproject.graph.LogInGraph;

public class ControllerUIModel {

	private InterGraph inter;
	private LogInGraph login;
	private MessaggioClient messaggioClient;

	private ActionListener gestoreSubmitInter;
	private ActionListener gestoreSubmitLogin;

	private HttpSecurity http;

	public ControllerUIModel(InterGraph inter, LogInGraph login, MessaggioClient messaggioClient) {
		this.inter = inter;
		this.login = login;
		this.messaggioClient = messaggioClient;
		gestoreEventi();

		// assegno il gestore di evento al bottone btnSubmit dell'interfaccia
		inter.getBtnSubmit().addActionListener(gestoreSubmitInter);

		login.getBtnSubmit().addActionListener(gestoreSubmitLogin);
	}

	public void gestoreEventi() {
		// Codice gestore dell'interfaccia grafica autenticata
		gestoreSubmitInter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				messaggioClient.setIndirizzoPortafoglio(inter.getPortafoglio());
				messaggioClient.setPrevisione(inter.getPrevisione());
				messaggioClient.setValuta(inter.getValuta());
				messaggioClient.setScommessa(inter.getScommessa());

				// chiamata al metodo API
				ApiResponse<String> apiResponse = APIClient.getAnswerFromServer(messaggioClient);
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
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URL("http://localhost:8080/oauth2/authorization/google").toURI());
				} catch (Exception a) {
					a.printStackTrace();
				}

			}
		};

	}

}
