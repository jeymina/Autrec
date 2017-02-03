package serveur.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "l_com_plat")
public class Com_Plat  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="lcomplat_com")
	private Commande complatCom;
	
	@Id
	@ManyToOne
	@JoinColumn(name="lcomplat_plat")
	private Plat complatPlat;

	@Column(name="lcomplat_quantite")
	private int quantite;

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
