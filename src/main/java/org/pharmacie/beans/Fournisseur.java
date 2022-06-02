package org.pharmacie.beans;

import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class Client
 */
@WebServlet("/Client")
public class Fournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* Propriétés du bean */
	private int idFournisseur;
	private String nomFournisseur;
	private String adresseFournisseur;
	private String emailFournisseur;
	private Date dateEnregistrementFournisseur;

	public Fournisseur() {
	}

	public Fournisseur(String nomFournisseur, String adresseFournisseur, String emailFournisseur, String dateAjoutFournisseur) {
		super();
		this.setNomFournisseur(nomFournisseur);
		this.setEmailFournisseur(emailFournisseur);
		this.setAdresseFournisseur(adresseFournisseur);
		this.setDateEnregistrementFournisseur(dateEnregistrementFournisseur);
	}

	public Fournisseur(int id, String nomFournisseur, String adresseFournisseur, String emailFournisseur, String dateAjoutFournisseur) {
		super();
		this.setIdFournisseur(id);
		this.setNomFournisseur(nomFournisseur);
		this.setEmailFournisseur(emailFournisseur);
		this.setAdresseFournisseur(adresseFournisseur);
		this.setDateEnregistrementFournisseur(dateEnregistrementFournisseur);
	}

	public int getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getAdresseFournisseur() {
		return adresseFournisseur;
	}

	public void setAdresseFournisseur(String adresseFournisseur) {
		this.adresseFournisseur = adresseFournisseur;
	}

	public String getEmailFournisseur() {
		return emailFournisseur;
	}

	public void setEmailFournisseur(String emailFournisseur) {
		this.emailFournisseur = emailFournisseur;
	}

	public Date getDateEnregistrementFournisseur() {
		return dateEnregistrementFournisseur;
	}

	public void setDateEnregistrementFournisseur(Date dateEnregistrementFournisseur) {
		this.dateEnregistrementFournisseur = dateEnregistrementFournisseur;
	}

}
