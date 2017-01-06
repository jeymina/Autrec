package serveur.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

	EntityManagerFactory emf = null;
	EntityManager em = null;

	public void ouvrir() {
		try {
			emf = Persistence.createEntityManagerFactory("tphibernate");
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
}
