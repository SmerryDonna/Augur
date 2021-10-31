package com.augur.client;

public class MessaggioClient {
	private String indirizzoPortafoglio;
	private String scommessa; // quota scommessa
	private String valuta;
	private String previsione; // previsione sul valore della moneta

	public MessaggioClient() {

	}

	public MessaggioClient(String indirizzoPortafoglio, String scommessa, String valuta, String previsione) {
		setIndirizzoPortafoglio(indirizzoPortafoglio);
		this.scommessa = scommessa;
		this.valuta = valuta;
		this.previsione = previsione;
	}

	public void setIndirizzoPortafoglio(String indirizzoPortafoglio) {
		this.indirizzoPortafoglio = indirizzoPortafoglio;
	}

	public void setScommessa(String scommessa) {
		this.scommessa = scommessa;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public void setPrevisione(String previsione) {
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
