package serveur.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "l_ing_plat")
public class Ing_Plat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="lingplat_plat")
	private Plat ingplatPlat;
	
	@Id
	@ManyToOne
	@JoinColumn(name="lingplat_ing")
	private Ingredient ingplatIng;

	@Column(name="ing_portion")
	private int portion;
	
	@Column(name="ing_montant")
	private float montant;

	public Plat getIngplatPlat() {
		return ingplatPlat;
	}

	public void setIngplatPlat(Plat ingplatPlat) {
		this.ingplatPlat = ingplatPlat;
	}

	public Ingredient getIngplatIng() {
		return ingplatIng;
	}

	public void setIngplatIng(Ingredient ingplatIng) {
		this.ingplatIng = ingplatIng;
	}

	public int getPortion() {
		return portion;
	}

	public void setPortion(int portion) {
		this.portion = portion;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}
	
}
