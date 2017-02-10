package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class DAO {

	@PersistenceContext
	static EntityManagerFactory emf = null;
	@PersistenceContext
	static EntityManager em;

	public static EntityManager getEM() {
		try {
			if (em == null){
				emf = Persistence.createEntityManagerFactory("restoKevina");
				em = emf.createEntityManager();		
			}
		}
		catch (Exception e) {
			System.out.println("Erreur DAO.getEM "+e.getMessage());
		}
		return em;

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
}
