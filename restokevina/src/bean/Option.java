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
@Table(name = "Option")
public class Option implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_id")
	private int id;
	
	@Column(name="cat_nom")
	private String nom;
	
	@OneToMany(mappedBy="optplatOpt")
	private Collection<Opt_Plat> listOptplat = new ArrayList<Opt_Plat>();

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

	public Collection<Opt_Plat> getListOptplat() {
		return listOptplat;
	}

	public void setListOptplat(Collection<Opt_Plat> listOptplat) {
		this.listOptplat = listOptplat;
	}

}
