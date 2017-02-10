package bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="util_id")
	private Integer id;

	@Column(name="util_nom")
	private String nom;

	@Column(name="util_prenom")
	private String prenom;

	@Column(name="util_pass")
	private String password;
	
	@Column(name="util_tel")
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "util_adr")
	private Adresse utilisateurAdr;
	
	@OneToMany(mappedBy="commandeUtil")
	private Collection<Commande> commande = new ArrayList<Commande>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getUtilisateurAdr() {
		return utilisateurAdr;
	}

	public void setUtilisateurAdr(Adresse utilisateurAdr) {
		this.utilisateurAdr = utilisateurAdr;
	}

	public Collection<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}

}
