package testing;

import java.util.List;

import serveur.bean.Commande;
import serveur.bean.Utilisateur;
import serveur.dao.DAO;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("coucou");

		DAO dao = new DAO();
		dao.ouvrir();

		List<Utilisateur> lst_cli = dao.listerUtilisateur();
		
		System.out.println();
		System.out.println("nb groupes = "+lst_cli.size());
		
		for (Utilisateur cli : lst_cli) {
			System.out.println("Client "+cli.getId()+":  Nom = "+cli.getNom()+ " ; Prenom = "+cli.getPrenom());

		}
		
		
		dao.fermer();
		
	}

}
