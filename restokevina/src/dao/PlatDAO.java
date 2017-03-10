package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Plat;

public class PlatDAO {
	
	public static List<Plat> getListePlat() {
		String req = "SELECT a FROM Plat a";
		TypedQuery<Plat> query = DAO.getEM().createQuery(req, Plat.class);
		return query.getResultList();
	}
	
	public static Plat getPlatById(int id) {
		Plat unPlat = DAO.getEM().find(Plat.class, id);
		return unPlat;
	}
	
	public static void createPlat(Plat unPlat) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unPlat);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updatePlat(Plat unPlat) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unPlat);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deletePlat(int id) {
		Plat unPlat = DAO.getEM().find(Plat.class, id);
		if (unPlat != null) {
			DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(unPlat);
			DAO.getEM().getTransaction().commit();			
		}
	}

}
