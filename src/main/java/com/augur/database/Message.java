package com.augur.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) int id;
	private String indirizzoPortafoglio;
	private String previsione;
	private String valuta;
	private String scommessa;

	public Message() {

	}

	public Message(String indirizzoPortafoglio, String previsione, String valuta, String scommessa) {
		super();
		this.indirizzoPortafoglio = indirizzoPortafoglio;
		this.previsione = previsione;
		this.valuta = valuta;
		this.scommessa = scommessa;
	}

	public String getIndirizzoPortafoglio() {
		return indirizzoPortafoglio;
	}

	public void setIndirizzoPortafoglio(String indirizzoProtafoglio) {
		this.indirizzoPortafoglio = indirizzoProtafoglio;
	}

	public String getPrevisione() {
		return previsione;
	}

	public void setPrevisione(String previsione) {
		this.previsione = previsione;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public String getScommessa() {
		return scommessa;
	}

	public void setScommessa(String scommessa) {
		this.scommessa = scommessa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
