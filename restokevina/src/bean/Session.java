package bean;

public class Session {

	private static Session INSTANCE;
	
	private String menuEnCours;
	
	private Utilisateur utilActif;
	
	private Session(){
		this.menuEnCours = "Mon menu !";
	}

	public static Session getInstance(){
		if (INSTANCE == null ) INSTANCE = new Session();
		return INSTANCE;
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
