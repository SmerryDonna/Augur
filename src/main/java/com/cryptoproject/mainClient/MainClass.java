package com.cryptoproject.mainClient;

import javax.swing.SwingUtilities;

import com.augur.client.APIClient;
import com.augur.client.MessaggioClient;
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
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() { // invocazione metodi di SWING tramite thread, usando la SWING utility sopra
				MessaggioClient messaggioClient = new MessaggioClient();
				APIClient apiClient = new APIClient(messaggioClient);
				LogInGraph login = new LogInGraph();
				InterGraph interGraph = new InterGraph();
				ControllerUIModel gestoreUI = new ControllerUIModel(interGraph, login, messaggioClient, apiClient);

			}
		});
	}
}
