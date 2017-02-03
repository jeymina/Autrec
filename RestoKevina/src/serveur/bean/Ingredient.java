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
@Table(name = "Ingredient")
public class Ingredient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ing_id")
	private int id;
	
	@Column(name="ing_nom")
	private String nom;
	
	@OneToMany(mappedBy="ingplatIng")
	private Collection<Ing_Plat> listIngplat = new ArrayList<Ing_Plat>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Ing_Plat> getListIngplat() {
		return listIngplat;
	}

	public void setListIngplat(Collection<Ing_Plat> listIngplat) {
		this.listIngplat = listIngplat;
	}



	
}
