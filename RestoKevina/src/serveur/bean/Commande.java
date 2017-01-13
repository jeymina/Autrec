package serveur.bean;

import java.io.Serializable;
import java.sql.Timestamp;

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

}
