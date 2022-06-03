package org.pharmacie.beans;

public class Stock {
	
	private String idStock;
	private String quantiteStock;
	private String dateAjout;
	private String idFournisseur;
	private int idUser;
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
	public void setDateAjout(String dateAjout) {
		this.dateAjout = dateAjout;
	}
	public String getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(String string) {
		this.idFournisseur = string;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
}
