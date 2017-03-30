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
		DAO.getEM().merge(unPlat);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updatePlat(Plat unPlat) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().merge(unPlat);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deletePlat(int id) {
		Plat unPlat = DAO.getEM().find(Plat.class, id);
		if (unPlat != null) {
			if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(unPlat);
			DAO.getEM().getTransaction().commit();			
		}
	}

	public static List<Plat> getListeEntree() {
		String req = "SELECT a FROM Plat a, Categorie b WHERE a.platCat=b.id AND b.id=1";
		TypedQuery<Plat> query = DAO.getEM().createQuery(req, Plat.class);
		return query.getResultList();
	}

	public static List<Plat> getListePlatPrinc() {
		String req = "SELECT a FROM Plat a, Categorie b WHERE a.platCat=b.id AND (b.id=2 OR b.id=3 OR b.id=5)";
		TypedQuery<Plat> query = DAO.getEM().createQuery(req, Plat.class);
		return query.getResultList();
	}

	public static List<Plat> getListeDessert() {
		String req = "SELECT a FROM Plat a, Categorie b WHERE a.platCat=b.id AND b.id=4";
		TypedQuery<Plat> query = DAO.getEM().createQuery(req, Plat.class);
		return query.getResultList();
	}

}
