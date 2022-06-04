package org.pharmacie.beans;

import java.sql.Date;

public class Produit{
	protected int idProduit;
	protected String nomProduit;
	protected String codeProduit;
	protected String disponibilite;
	protected Date dateAjout;
	protected int poids ;
	protected String descriptionProduit;
	protected String originProduit ;
	protected int prix ;
	
	
	public Produit() {
		
	}
	
	public Produit(String nprod, String cprod, Date dateA,int poid, String dproduit, String oproduit,int prix) {
		super();
		this.nomProduit = nprod;
		this.codeProduit = cprod;
		this.dateAjout = dateA;
		this.poids = poid ;
		this.descriptionProduit = dproduit;
		this.originProduit = oproduit;
		this.prix = prix;
	}
	
	public Produit(int id, String nprod, String cprod, Date dateA,int poid, String dproduit, String oproduit,int prix) {
		super();
		this.idProduit = id;
		this.nomProduit = nprod;
		this.codeProduit = cprod;
		this.dateAjout = dateA;
		this.poids = poid ;
		this.descriptionProduit = dproduit;
		this.originProduit = oproduit;
		this.prix = prix;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}
	
	public String getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public String getDescriptionProduit() {
		return descriptionProduit;
	}

	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}

	public String getOriginProduit() {
		return originProduit;
	}

	public void setOriginProduit(String originProduit) {
		this.originProduit = originProduit;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	
	
	
}