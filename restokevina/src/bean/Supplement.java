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
	@Column(name="sup_id")
	private int id;
	
	@Column(name="sup_nom")
	private String nom;
	
	@JsonIgnore
	@OneToMany(mappedBy="supplatSup")
	private Collection<Sup_Plat> listSupplat = new ArrayList<Sup_Plat>();

	@JsonIgnore
	@OneToMany(mappedBy="complasupSup")
	private Collection<Complat_Sup> listComplasup = new ArrayList<Complat_Sup>();
	
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

	public Collection<Sup_Plat> getListSupplat() {
		return listSupplat;
	}

	public void setListSupplat(Collection<Sup_Plat> listSupplat) {
		this.listSupplat = listSupplat;
	}




}
