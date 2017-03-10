package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Utilisateur;

public class UtilisateurDAO {

	public static List<Utilisateur> getListeUtilisateur() {
		String req = "SELECT a FROM Utilisateur a";
		TypedQuery<Utilisateur> query = DAO.getEM().createQuery(req, Utilisateur.class);
		return query.getResultList();
	}
	
	public static Utilisateur getUtilisateurbyId(int id) {
		Utilisateur unUtilisateur = DAO.getEM().find(Utilisateur.class, id);
		return unUtilisateur;
	}
	
	public static void createUtilisateur(Utilisateur unUtilisateur) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unUtilisateur);
		DAO.getEM().getTransaction().commit();
	}

	public static void updateUtilisateur(Utilisateur unUtilisateur) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unUtilisateur);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteUtilisateur(int id) {
		Utilisateur unUtilisateur = DAO.getEM().find(Utilisateur.class, id);
		if (unUtilisateur != null) {
			DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(unUtilisateur);
			DAO.getEM().getTransaction().commit();			
		}
	}
}
