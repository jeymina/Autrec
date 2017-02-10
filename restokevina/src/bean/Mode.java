package bean;

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
@Table(name = "Mode")
public class Mode implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mode_id")
	private Integer id;

	@Column(name="mode_nom")
	private String nom;
	
	@OneToMany(mappedBy="paiementMode")
	private Collection<Paiement> listCommande = new ArrayList<Paiement>();

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

	public Collection<Paiement> getCommande() {
		return listCommande;
	}

	public void setCommande(Collection<Paiement> listCommande) {
		this.listCommande = listCommande;
	}
	
}
