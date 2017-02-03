package testing;

import java.util.List;

import serveur.bean.Commande;
import serveur.bean.Ing_Plat;
import serveur.bean.Ingredient;
import serveur.bean.Plat;
import serveur.bean.Utilisateur;
import serveur.dao.DAO;

public class HelloWorld {

	public static void main(String[] args) {

		DAO dao = new DAO();
		dao.ouvrir();

		List<Utilisateur> lst_cli = dao.listerUtilisateur();
		List<Plat> lst_plat = dao.listerPlat();
		
		for (Utilisateur cli : lst_cli) {
			System.out.println("Client "+cli.getId()+":  Nom = "+cli.getNom()+ " ; Adresse : "+cli.getUtilisateurAdr().getVille());

		}
		
		for (Plat plat : lst_plat) {
			System.out.println("Plat : "+plat.getNom());
			for (Ing_Plat ing_Plat : plat.getListIngPlat()) {
				Ingredient ing = ing_Plat.getIngplatIng();
				System.out.println("    Ingredient : "+ing.getNom());
			}

		}
		
		
		dao.fermer();
		
	}

}
