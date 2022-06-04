package org.pharmacie.beans;


public class Stock {
	
	private String idStock;
	private String quantiteStock;
	private String dateAjout;
	private String idFournisseur;
	private String idUser;
	private String idProduit;
	
	public String getIdStock() {
		return idStock;
	}
	public void setIdStock(String string) {
		this.idStock = string;
	}
	public String getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(String string) {
		this.quantiteStock = string;
	}
	public String getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(String date) {
		this.dateAjout = date;
	}
	public String getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(String string) {
		this.idFournisseur = string;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String object) {
		this.idUser = object;
	}
	public String getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
}
