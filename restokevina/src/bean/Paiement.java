package bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Paiement")
public class Paiement implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="paie_id")
	private Integer id;

	@Column(name="paie_montant")
	private float montant;

	@Column(name="paie_date")
	private Timestamp datePaiement;

	@ManyToOne
	@JoinColumn(name = "paie_mode")
	private Mode paiementMode;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "paie_com")
	private Commande paiementCom;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Timestamp getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Timestamp datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Mode getPaiementMode() {
		return paiementMode;
	}

	public void setPaiementMode(Mode paiementMode) {
		this.paiementMode = paiementMode;
	}

	public Commande getPaiementCom() {
		return paiementCom;
	}

	public void setPaiementCom(Commande paiementCom) {
		this.paiementCom = paiementCom;
	}
	
}
