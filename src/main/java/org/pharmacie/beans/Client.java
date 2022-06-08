package org.pharmacie.beans;

import java.sql.Date;

public class Client{
	protected int idClient ;
	protected String nomClient;
	protected String telephoneClient;
	protected String emailClient;
	protected Date dateAjoutClient;
	
	public Client() {
	}
	
	public Client(String nomClient, String telephoneClient, String emailClient, Date dateAjoutClient) {
		super();
		this.nomClient = nomClient;
		this.telephoneClient = telephoneClient;
		this.emailClient = emailClient;
		this.dateAjoutClient = dateAjoutClient;
	}
	
	public Client(int idClient , String nomClient, String telephoneClient, String emailClient, Date dateAjoutClient) {
		super();
		this.idClient  = idClient ;
		this.nomClient = nomClient;
		this.telephoneClient = telephoneClient;
		this.emailClient = emailClient;
		this.dateAjoutClient = dateAjoutClient;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getTelephoneClient() {
		return telephoneClient;
	}

	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public Date getDateAjoutClient() {
		return dateAjoutClient;
	}

	public void setDateAjoutClient(Date dateAjoutClient2) {
		this.dateAjoutClient = dateAjoutClient2;
	}

}