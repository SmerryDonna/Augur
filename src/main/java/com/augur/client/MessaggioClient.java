package com.augur.client;

public class MessaggioClient {
	private String indirizzoPortafoglio;
	private String scommessa; // quota scommessa
	private String valuta;
	private String previsione; // previsione sul valore della moneta

	public MessaggioClient(String indirizzoPortafoglio, String scommessa, String valuta, String previsione) {
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
