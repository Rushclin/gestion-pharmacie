
package org.pharmacie.beans;

import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class Client
 */
@WebServlet("/Commande")
public class Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* Propri�t�s du bean */
	private int idCommande;
	private int quantiteCommande;
	private int prixCommande;
	private Date dateCommande;
	private int idClient;
	
//	private Client client;

	public Commande() {
	}

	public Commande(int quantiteCommande, int prixCommande, Date dateCommande, int idClient) {
		super();
		this.setQuantiteCommande(quantiteCommande);
		this.setPrixCommande(prixCommande);
		this.setDateCommande(dateCommande);
		this.setIdClient(idClient);
	}
//	public Commande(int quantiteCommande, int prixCommande, Date dateCommande, int idClient, Client client) {
//		super();
//		this.setQuantiteCommande(quantiteCommande);
//		this.setPrixCommande(prixCommande);
//		this.setDateCommande(dateCommande);
//		this.setIdClient(idClient);
//		this.setClient(client);
//	}

	public Commande(int idCommande, int quantiteCommande, int prixCommande, Date dateCommande, int idClient) {
		super();
		this.setIdCommande(idCommande);
		this.setQuantiteCommande(quantiteCommande);
		this.setPrixCommande(prixCommande);
		this.setDateCommande(dateCommande);
		this.setIdClient(idClient);
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getQuantiteCommande() {
		return quantiteCommande;
	}

	public void setQuantiteCommande(int quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}

	public int getPrixCommande() {
		return prixCommande;
	}

	public void setPrixCommande(int prixCommande) {
		this.prixCommande = prixCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = new Client();
//	}



}
