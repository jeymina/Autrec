package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "l_com_plat")
public class Com_Plat  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(name="lcomplat_com")
	private Commande complatCom;
	
	@Id
	@ManyToOne
	@JoinColumn(name="lcomplat_plat")
	private Plat complatPlat;

	@OneToMany(mappedBy="complatsupComplat")
	private Collection<Complat_Sup> listComplasup = new ArrayList<Complat_Sup>();

	@Column(name="lcomplat_quantite")
	private int quantite;

	public Collection<Complat_Sup> getListComplasup() {
		return listComplasup;
	}

	public void setListComplasup(Collection<Complat_Sup> listComplasup) {
		this.listComplasup = listComplasup;
	}

	public Commande getComplatCom() {
		return complatCom;
	}

	public void setComplatCom(Commande complatCom) {
		this.complatCom = complatCom;
	}

	public Plat getComplatPlat() {
		return complatPlat;
	}

	public void setComplatPlat(Plat complatPlat) {
		this.complatPlat = complatPlat;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
