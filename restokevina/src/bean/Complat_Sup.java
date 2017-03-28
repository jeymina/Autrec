package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "l_complat_sup")
public class Complat_Sup implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name="lcomplatsup_lcomplat_com"),
	    @JoinColumn(name="lcomplatsup_lcomplat_plat")
	})
	private Com_Plat complatsupComplat;

	@Id
	@ManyToOne
	@JoinColumn(name="lcomplatsup_sup")
	private Supplement complasupSup;

	public Com_Plat getComplatsupComplat() {
		return complatsupComplat;
	}

	public void setComplatsupComplat(Com_Plat complatsupComplat) {
		this.complatsupComplat = complatsupComplat;
	}

	public Supplement getComplasupSup() {
		return complasupSup;
	}

	public void setComplasupSup(Supplement complasupSup) {
		this.complasupSup = complasupSup;
	}
}
