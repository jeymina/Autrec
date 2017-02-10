package bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class Client {
	
	@NotEmpty(message="Le nom ne peut pas être vide")
	@Size(min=3 , message="Le nom doit avoir au moins 3 caractères")
	private String nom = null;

	@NotEmpty(message="Le prénom ne peut pas être vide")
	@Size(min=3 , message="Le prénom doit avoir au moins 3 caractères")
	private String prenom = null;
	
	public Client() {
		
	}
	
	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


}
