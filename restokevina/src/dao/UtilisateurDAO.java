package dao;

import java.util.List;

import javax.persistence.NoResultException;
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
		if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unUtilisateur);
		DAO.getEM().getTransaction().commit();
	}

	public static void updateUtilisateur(Utilisateur unUtilisateur) {
		if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unUtilisateur);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteUtilisateur(int id) {
		Utilisateur unUtilisateur = DAO.getEM().find(Utilisateur.class, id);
		if (unUtilisateur != null) {
			if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(unUtilisateur);
			DAO.getEM().getTransaction().commit();			
		}
	}

	public static List<Utilisateur> connexion(String mail, String pass) {
		String req = "SELECT a FROM Utilisateur a WHERE a.mail=:mail AND a.password=:password";
		TypedQuery<Utilisateur> query = DAO.getEM().createQuery(req, Utilisateur.class);
		query.setParameter("mail", mail);
		query.setParameter("password", pass);
		return query.getResultList();		
	}

	public static Utilisateur getUtilisateurbyMail(String mail) {
		String req = "SELECT a FROM Utilisateur a WHERE a.mail=:mail";
		TypedQuery<Utilisateur> query = DAO.getEM().createQuery(req, Utilisateur.class);
		query.setParameter("mail", mail);
		Utilisateur u;
		try{
			u = query.getSingleResult();			
		}catch (NoResultException e) {
			System.err.println("Pas d'utilisateur avec le mail '"+mail+"' trouvé");
			return null;
		}
		return u;
	}
}
