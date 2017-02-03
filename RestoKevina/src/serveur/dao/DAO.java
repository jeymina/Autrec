package serveur.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import serveur.bean.Plat;
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
	
	public List<Object> getListFromRequest(String request){
		return em.createQuery(request).getResultList();
	}
	
	
	
	public List<Utilisateur> listerUtilisateur() {
		List <Utilisateur> lst = em.createQuery("select a from Utilisateur a").getResultList();
		return lst;
	}
	
	public List<Plat> listerPlat() {
		List <Plat> lst = em.createQuery("select a from Plat a").getResultList();
		return lst;
	}
	
	
}
