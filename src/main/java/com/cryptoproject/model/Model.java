package com.cryptoproject.model;

import java.awt.event.ActionListener;

public class Model {
	

    private String indirizzoProtafoglio;
	private String previsione;
	private String valuta;
	private String scommessa;
	
	private String username;
	private String psw;


	public Model() {
		
		this.indirizzoProtafoglio = null;
		this.previsione = null;
		this.valuta = null;
		this.scommessa = null;
		
		this.username = null;
		this.psw = null;
	}
	
	public void setIndirizzo(String indirizzoPortafoglio)
	{
		this.indirizzoProtafoglio = indirizzoPortafoglio;
	}
	
	public void setPrevisione(String previsione)
	{
		this.previsione = previsione;
	}
	
	public void setValuta(String valuta)
	{
		this.valuta = valuta;
	}
	
	public void setScommessa(String scommessa)
	{
		this.scommessa = scommessa;
	}
	
	
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPsw(String psw)
	{
		this.psw = psw;
	}
	
}
