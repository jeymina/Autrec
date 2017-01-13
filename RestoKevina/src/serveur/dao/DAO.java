package serveur.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import serveur.bean.Utilisateur;

public class DAO {

	EntityManagerFactory emf = null;
	EntityManager em = null;

	public void ouvrir() {
		try {
			emf = Persistence.createEntityManagerFactory("restoKevina");
			em = emf.createEntityManager();		
		}
		catch (Exception e) {
			System.out.println("Erreur DAO.ouvrir "+e.getMessage());
		}

	}

	public void fermer() {
		try {
			em.close();
			emf.close();
		}
		catch (Exception e) {
			System.out.println("Erreur DAO.fermer "+e.getMessage());
		}

	}
	
	
	public List<Utilisateur> listerUtilisateur() {
		List <Utilisateur> lst = em.createQuery("select c from Utilisateur c").getResultList();
		return lst;
	}
	
	
	
}
