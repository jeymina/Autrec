package bean;

public class Session {

	private static Session INSTANCE;
	
	private String menuEnCours;
	
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
}
