package serveur.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "Plat")
public class Plat  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="plat_id")
	private int id;
	
	@Column(name="plat_nom")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "plat_cat")
	private Categorie platCat;

	@OneToMany(mappedBy="complatPlat")
	private Collection<Com_Plat> listComPlat = new ArrayList<Com_Plat>();
	
	@OneToMany(mappedBy="ingplatPlat")
	private Collection<Ing_Plat> listIngPlat = new ArrayList<Ing_Plat>();
	
	@OneToMany(mappedBy="optplatPlat")
	private Collection<Opt_Plat> listOptPlat = new ArrayList<Opt_Plat>();

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

	public Categorie getPlatCat() {
		return platCat;
	}

	public void setPlatCat(Categorie platCat) {
		this.platCat = platCat;
	}

	public Collection<Com_Plat> getListComPlat() {
		return listComPlat;
	}

	public void setListComPlat(Collection<Com_Plat> listComPlat) {
		this.listComPlat = listComPlat;
	}

	public Collection<Ing_Plat> getListIngPlat() {
		return listIngPlat;
	}

	public void setListIngPlat(Collection<Ing_Plat> listIngPlat) {
		this.listIngPlat = listIngPlat;
	}

	public Collection<Opt_Plat> getListOptPlat() {
		return listOptPlat;
	}

	public void setListOptPlat(Collection<Opt_Plat> listOptPlat) {
		this.listOptPlat = listOptPlat;
	}

}
