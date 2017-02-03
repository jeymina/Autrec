package serveur.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "Commande")
public class Commande implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="com_id")
	private Integer id;
	
	@Column(name="com_date_validation")
	private Timestamp dateValidation;
	
	@Column(name="com_date_livraison")
	private Timestamp dateLivraison;

	@ManyToOne
	@JoinColumn(name = "com_util")
	private Utilisateur commandeUtil;

	@ManyToOne
	@JoinColumn(name = "com_adr")
	private Adresse commandeAdr;

	@OneToMany(mappedBy="paiementCom")
	private Collection<Paiement> listPaiement = new ArrayList<Paiement>();

	@OneToMany(mappedBy="complatCom")
	private Collection<Com_Plat> listComPlat = new ArrayList<Com_Plat>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(Timestamp dateValidation) {
		this.dateValidation = dateValidation;
	}

	public Timestamp getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Timestamp dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Utilisateur getCommandeUtil() {
		return commandeUtil;
	}

	public void setCommandeUtil(Utilisateur commandeUtil) {
		this.commandeUtil = commandeUtil;
	}

	public Adresse getCommandeAdr() {
		return commandeAdr;
	}

	public void setCommandeAdr(Adresse commandeAdr) {
		this.commandeAdr = commandeAdr;
	}

	public Collection<Paiement> getListPaiement() {
		return listPaiement;
	}

	public void setListPaiement(Collection<Paiement> listPaiement) {
		this.listPaiement = listPaiement;
	}

	public Collection<Com_Plat> getListComPlat() {
		return listComPlat;
	}

	public void setListComPlat(Collection<Com_Plat> listComPlat) {
		this.listComPlat = listComPlat;
	}
}
