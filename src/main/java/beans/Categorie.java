package beans;

public class Categorie {
private int idCategorie;
private String nomCategorie;
private String description;
public Categorie(){
	
}
public Categorie( int id,String nomCategorie, String description) {
super();
this.setIdCategorie(id);
this.setNomCategorie(nomCategorie);
this.setDescription(description);
}
public int getIdCategorie() {
	return idCategorie;
}
public void setIdCategorie(int idCategorie) {
	this.idCategorie = idCategorie;
}
public String getNomCategorie() {
	return nomCategorie;
}
public void setNomCategorie(String nomCategorie) {
	this.nomCategorie = nomCategorie;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
}
