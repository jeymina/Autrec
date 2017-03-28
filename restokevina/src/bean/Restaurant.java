package bean;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {

	private static Restaurant INSTANCE;
	
	private String nom;
	
	private String adresse;
	
	private String cp;
	
	private String ville;
	
	private String tel;
	
	private Map<String, Session> sessions = new HashMap<String, Session>();

	private Restaurant(){}
	
	public static Restaurant getInstance(){
		if (INSTANCE == null ) INSTANCE = new Restaurant();
		return INSTANCE;
	}
	
	public Map<String, Session> getSessions() {
		return sessions;
	}

	public void setSessions(Map<String, Session> sessions) {
		this.sessions = sessions;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Session getSessions(String remoteAddr) {
		if (this.sessions.get(remoteAddr) == null){			
			this.sessions.put(remoteAddr, new Session());
		}
		return this.sessions.get(remoteAddr);
	}
	
}
