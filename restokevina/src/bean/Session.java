package bean;

public class Session {
	
	private String menuEnCours;
	
	private Utilisateur utilActif;
	
	public Session(){
	}

	public String getMenuEnCours() {
		return menuEnCours;
	}


	public void setMenuEnCours(String menuEnCours) {
		this.menuEnCours = menuEnCours;
	}


	public Utilisateur getUtilActif() {
		return utilActif;
	}


	public void setUtilActif(Utilisateur utilActif) {
		this.utilActif = utilActif;
	}
}
