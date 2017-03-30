package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Categorie;

public class CategorieDAO {
	
	public static List<Categorie> getListeCategorie() {
		String req = "SELECT a FROM Categorie a";
		TypedQuery<Categorie> query = DAO.getEM().createQuery(req, Categorie.class);
		return query.getResultList();
	}
	
	public static Categorie getCategorieById(int id) {
		Categorie uneCategorie = DAO.getEM().find(Categorie.class, id);
		return uneCategorie;
	}

	public static void createCategorie(Categorie uneCategorie) {
		if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
		DAO.getEM().merge(uneCategorie);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updateCategorie(Categorie uneCategorie) {
		if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
		DAO.getEM().merge(uneCategorie);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteCategorie(int id) {
		Categorie uneCategorie = DAO.getEM().find(Categorie.class, id);
		if (uneCategorie != null) {
			if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(uneCategorie);
			DAO.getEM().getTransaction().commit();			
		}
	}
}
