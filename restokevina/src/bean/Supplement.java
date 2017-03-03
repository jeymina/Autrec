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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Supplement")
public class Supplement implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="opt_id")
	private int id;
	
	@Column(name="opt_nom")
	private String nom;
	
	@JsonIgnore
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
