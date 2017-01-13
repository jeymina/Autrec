package serveur.bean;

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
	private Mode mode;
	
	@ManyToOne
	@JoinColumn(name = "paie_com")
	private Commande commande;
	
}
