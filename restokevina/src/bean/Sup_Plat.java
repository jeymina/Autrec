package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "l_sup_plat")
public class Sup_Plat implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(name="lsupplat_plat")
	private Plat supplatPlat;
	
	@Id
	@ManyToOne
	@JoinColumn(name="lsupplat_sup")
	private Supplement supplatSup;

	public Plat getSupplatPlat() {
		return supplatPlat;
	}

	public void setSupplatPlat(Plat supplatPlat) {
		this.supplatPlat = supplatPlat;
	}

	public Supplement getSupplatSup() {
		return supplatSup;
	}

	public void setSupplatSup(Supplement supplatSup) {
		this.supplatSup = supplatSup;
	}

	
}
