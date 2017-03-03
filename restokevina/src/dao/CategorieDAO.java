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

}
