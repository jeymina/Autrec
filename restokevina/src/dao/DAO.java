package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

@Service
public class DAO {

	EntityManagerFactory emf = null;
	static EntityManager em;

	public DAO() {
		System.out.println("DAO opening");
		emf = Persistence.createEntityManagerFactory("restokevina");
		em = emf.createEntityManager();
		System.out.println("DAO opened");
	}
	
	public static EntityManager getEM(){
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
