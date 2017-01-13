package serveur.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Adresse")
public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adr_id")
	private Integer id;
	
	@Column(name="adr_voirie")
	private String voirie;
	
	@Column(name="adr_cp")
	private String cp;
	
	@Column(name="adr_ville")
	private String ville;
	
	@OneToMany(mappedBy="utilisateurAdr")
	private Collection<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
	
	@OneToMany(mappedBy="commandeAdr")
	private Collection<Commande> listCommande = new ArrayList<Commande>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVoirie() {
		return voirie;
	}

	public void setVoirie(String voirie) {
		this.voirie = voirie;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Collection<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}

	public void setListUtilisateur(Collection<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}

	public Collection<Commande> getListCommande() {
		return listCommande;
	}

	public void setListCommande(Collection<Commande> listCommande) {
		this.listCommande = listCommande;
	}

}
