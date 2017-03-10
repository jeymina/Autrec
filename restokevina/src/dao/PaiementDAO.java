package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Paiement;

public class PaiementDAO {
	
	public static List<Paiement> getListePaiement() {
		String req = "SELECT a FROM Paiement a";
		TypedQuery<Paiement> query = DAO.getEM().createQuery(req, Paiement.class);
		return query.getResultList();
	}

	public static Paiement getPaiementById(int id) {
		Paiement unPaiement = DAO.getEM().find(Paiement.class, id);
		return unPaiement;
	}
	
	public static void createPaiement(Paiement unPaiement) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unPaiement);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updatePaiement(Paiement unPaiement) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unPaiement);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deletePaiement(int id) {
		Paiement unPaiement = DAO.getEM().find(Paiement.class, id);
		if (unPaiement != null) {
			DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(unPaiement);
			DAO.getEM().getTransaction().commit();			
		}
	}
	
}
