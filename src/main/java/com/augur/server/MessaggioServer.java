package com.augur.server;

public class MessaggioServer {

	private String indirizzoPortafoglio;
	private String scommessa;
	private String valuta;
	private String previsione;

	public MessaggioServer(String indirizzoPortafoglio, String scommessa, String valuta, String previsione) {
		this.indirizzoPortafoglio = indirizzoPortafoglio;
		this.scommessa = scommessa;
		this.valuta = valuta;
		this.previsione = previsione;
	}

	public String getIndirizzoPortafoglio() {
		return indirizzoPortafoglio;
	}

	public String getScommessa() {
		return scommessa;
	}

	public String getValuta() {
		return valuta;
	}

	public String getPrevisione() {
		return previsione;
	}

}
