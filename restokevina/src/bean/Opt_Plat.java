package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "l_opt_plat")
public class Opt_Plat implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(name="loptplat_plat")
	private Plat optplatPlat;
	
	@Id
	@ManyToOne
	@JoinColumn(name="loptplat_opt")
	private Supplement optplatOpt;

	public Plat getOptplatPlat() {
		return optplatPlat;
	}

	public void setOptplatPlat(Plat optplatPlat) {
		this.optplatPlat = optplatPlat;
	}

	public Supplement getOptplatOpt() {
		return optplatOpt;
	}

	public void setOptplatOpt(Supplement optplatOpt) {
		this.optplatOpt = optplatOpt;
	}
	
}
