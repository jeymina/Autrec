package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Supplement;

public class SupplementDAO {
	
	public static List<Supplement> getListeSupplement() {
		String req = "SELECT a FROM Supplement a";
		TypedQuery<Supplement> query = DAO.getEM().createQuery(req, Supplement.class);
		return query.getResultList();
	}

	public static Supplement getSupplementbyId(int id) {
		Supplement unSupplement = DAO.getEM().find(Supplement.class, id);
		return unSupplement;
	}
	
	public static void createSupplement(Supplement unSupplement) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unSupplement);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updateSupplement(Supplement unSupplement) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unSupplement);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteSupplement(int id) {
		Supplement unSupplement = DAO.getEM().find(Supplement.class, id);
		if (unSupplement != null) {
			DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(unSupplement);
			DAO.getEM().getTransaction().commit();			
		}
	}
	
}
